package com.gupaoedu.demo.mvcframework.servlet;


import com.gupaoedu.demo.mvcframework.annotation.GPController;
import com.gupaoedu.demo.mvcframework.annotation.GpService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by robin on 19/1/18.
 */
public class GPDispacherServlet extends HttpServlet {

    // 所有的配置信息都存入了 Properties中, Key - Value
    private Properties properties = new Properties();
    private List<String> classNames = new ArrayList<>();
    private Map<String, Object> ioc = new HashMap<>();

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


    private void doInstance() {
        if (classNames.isEmpty()) return;
        try {

            // 如果不为空, 利用反射机制, 将刚刚扫描进来的className初始化
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);

                // 进入Bean的实例化阶段, 初始化IOC容器
                // 不是所有牛奶都叫特仑苏
                if (clazz.isAnnotationPresent(GPController.class)) {

                } else if (clazz.isAnnotationPresent(GpService.class)) {

                } else {
                    continue;
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    // 运行时的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
