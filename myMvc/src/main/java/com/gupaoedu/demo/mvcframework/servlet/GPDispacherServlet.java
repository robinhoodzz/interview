package com.gupaoedu.demo.mvcframework.servlet;


import com.gupaoedu.demo.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by robin on 19/1/18.
 */
public class GPDispacherServlet extends HttpServlet {

    // 所有的配置信息都存入了 Properties中, Key - Value
    private Properties properties = new Properties();
    private List<String> classNames = new ArrayList<>();
    private Map<String, Object> ioc = new HashMap<>();
        private Map<String, Method> handlerMapping = new HashMap<>();
//    private List<Handler> handlerMapping = new ArrayList<>();

    // 初始化阶段
    @Override
    public void init(ServletConfig config) throws ServletException {

        /**
         * 1. 加载配置文件
         *
         * 2. 根据配置文件扫描所有的相关的类
         *
         * 3. 初始化所有的相关类的实例, 并且将其放入到IOC容器中, 也就是Map中
         *
         * 4. 实现(自动) 依赖注入
         *
         * 5. 初始化HandlerMapping
         *
         * 6. 等待请求, 进入运行阶段
         */

        // 1. 加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        // 2. 根据配置文件扫描所有的相关的类
        doScanner(properties.getProperty("scanPackage"));
        // 3. 初始化所有的相关类的实例, 并且将其放入到IOC容器中, 也就是Map中
        doInstance();
        // 4. 实现(自动) 依赖注入
        doAutoWired();
        // 5. 初始化HandlerMapping
        doInitHandlerMapping();

        System.out.println("--- GP mvc is init ---");
    }

    private void doInitHandlerMapping() {
        if (ioc.isEmpty()) return;


        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            // 判断
            if (clazz.isAnnotationPresent(GPController.class)) {
                continue;
            }

            String baseUrl = null;
            if (clazz.isAnnotationPresent(GpRequestMapping.class)) {
                GpRequestMapping gpRequestMapping = clazz.getAnnotation(GpRequestMapping.class);
                baseUrl = gpRequestMapping.value();
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {

                if (!clazz.isAnnotationPresent(GpRequestMapping.class)) continue;


                GpRequestMapping requestMapping = method.getAnnotation(GpRequestMapping.class);
                String url = (baseUrl + requestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("Mapping " + url + "," + method);


                /**
                 *
                 * GpRequestMapping requestMapping = method.getAnnotation(GpRequestMapping.class);
                 * String regex = ("/" + baseUrl + requestMapping.value()).replaceAll("/+", "/");
                 * Pattern pattern = Pattern.compile(regex);
                 * handlerMapping.add(new Handler(pattern, entry.getValue(), method));
                 * System.out.println("Mapping " + regex + "," + method);
                 *
                 */


            }
        }
    }

    private void doAutoWired() {
        if (ioc.isEmpty()) return;

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            // 首先第一步要获取到所有的字段(field)

            // 不论private还是protected还是default, 都要强制注入
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (!field.isAnnotationPresent(GpAutowried.class)) {
                    continue;
                }

                GpAutowried gpAutowried = field.getAnnotation(GpAutowried.class);
                String beanName = gpAutowried.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }

                // 要想访问到私有的, 或者受保护的, 我们强制授权访问
                // 不管你愿不愿意, 咱们都要强吻
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }


            }
        }
    }


    private void doInstance() {
        if (classNames.isEmpty()) return;
        try {

            // 如果不为空, 利用反射机制, 将刚刚扫描进来的className初始化
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);

                // 进入Bean的实例化阶段, 初始化IOC容器
                // 不是所有牛奶都叫特仑苏

                // IOC容器规则
                // 1. key默认用类名首字母小写
                // 2. 如果用字自定义名字, 那么要优先选择自定义的名字
                // 3. 如果是接口的话, 我们可以巧妙地用接口的类型作为key


                if (clazz.isAnnotationPresent(GPController.class)) {
                    String beanName = this.lowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(GpService.class)) {
                    GpService gpService = clazz.getAnnotation(GpService.class);
                    String beanName = gpService.value();
                    if ("".equals(beanName.trim())) {
                        beanName = this.lowerFirstCase(clazz.getSimpleName());
                    }

                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);

                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> i : interfaces) {
                        // 将接口的类型作为key
                        ioc.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 首字母小写
     *
     * @param beanName bean名称
     * @return
     */
    private String lowerFirstCase(String beanName) {
        char[] charArray = beanName.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

    /**
     * @param packAgeName
     */
    private void doScanner(String packAgeName) {

        // 进行递归扫描
        URL url = this.getClass().getClassLoader().getResource("/" + packAgeName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packAgeName + "." + file.getName());

            } else {
                String clazzName = packAgeName + "." + file.getName().replace(".class", "");
                classNames.add(clazzName);
            }

        }

    }

    /**
     * @param location
     */
    private void doLoadConfig(String location) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            Handler handler = getHandler(req);
//            if (handler == null) {
//                // 如果没有匹配上, 返回404错误
//                resp.getWriter().write("404 Not Found");
//                return;
//            }
//
//            // 获取方法的参数列表
//            Class<?>[] paramTypes = handler.method.getParameterTypes();
//
//            // 保存所有需要自动赋值的参数
//            Object[] paramValues = new Object[paramTypes.length];
//
//            Map<String, String[]> params = req.getParameterMap();
//
//            for (Map.Entry<String, String[]> param : params.entrySet()) {
//                String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]]", "");
//
//                // 如果找到匹配的对象, 则开始填充参数值
//                if(!handler.paramIndexMapping.containsKey(param.getKey())) continue;
//
//                int index = handler.paramIndexMapping.get(param.getKey());
////                paramValues[index] = convert(paramTypes[index], value);
//            }
//
//            // 设置方法中的request和response对象
//            int reqIndex = handler.paramIndexMapping.get(HttpServletRequest.class.getName());
//            paramValues[reqIndex] = req;
//            int respIndex = handler.paramIndexMapping.get(HttpServletResponse.class.getName());
//            paramValues[respIndex] = resp;
//
//
//            handler.method.invoke(handler.controller, paramValues);
//
//
//
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    private Handler getHandler(HttpServletRequest req) throws Exception {
//        if (handlerMapping.isEmpty()) return null;
//
//        String url = req.getRequestURI();
//        String contextPath = req.getContextPath();
//        url = url.replace(contextPath, "").replaceAll("/+", "/");
//
//        for (Handler handler : handlerMapping) {
//            try {
//                Matcher matcher = handler.pattern.matcher(url);
//                if(!matcher.matches()) continue;
//
//                return handler;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    // 运行时的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        if (!handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 Not Found");
            return;
        }
        Method method = handlerMapping.get(url);
        // 反射的方法
        // 需要2个参数, 第一个参数: 拿到这个method的instance, 第二个参数:要拿到实参, 从request中取值
//        method.invoke()
    }

    /**
     * Handler 记录 Controller中的RequestMapping和Method的关系
     */
    private class Handler {
        protected Object controller; // 保存方法对应的实例
        protected Method method;     // 保存映射的方法
        protected Pattern pattern;
        protected Map<String, Integer> paramIndexMapping; // 参数顺序

        protected Handler(Pattern pattern, Object controller, Method method) {
            this.controller = controller;
            this.method = method;
            this.pattern = pattern;

            paramIndexMapping = new HashMap<>();
            this.putParamIndexMapping(method);

        }

        private void putParamIndexMapping(Method method) {

            // 提取方法中加了注解的参数
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                for (Annotation a : parameterAnnotations[i]) {
                    if (a instanceof GpRequestParam) {
                        String paraName = ((GpRequestParam) a).value();
                        if (!"".equals(paraName)) {
                            paramIndexMapping.put(paraName, i);
                        }
                    }
                }
            }


            // 提起方法中的request和response参数
            Class<?>[] paramsTypes = method.getParameterTypes();
            for (int i = 0; i < paramsTypes.length; i++) {
                Class<?> type = paramsTypes[i];
                if (type == HttpServletRequest.class) {
                    paramIndexMapping.put(type.getName(), i);
                }
            }
        }
    }

}


