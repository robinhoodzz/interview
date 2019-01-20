package com.gupaoedu.demo.mvc.action;

import com.gupaoedu.demo.mvcframework.annotation.GPController;
import com.gupaoedu.demo.mvcframework.annotation.GpAutowried;
import com.gupaoedu.demo.mvcframework.annotation.GpRequestMapping;
import com.gupaoedu.demo.mvcframework.annotation.GpRequestParam;
import com.gupaoedu.demo.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by robin on 19/1/18.
 */
@GPController("/demo") // 这里存Id, 也就是该控制器的Id
@GpRequestMapping("/demo") // 这里传入URL
public class DemoAction {

    @GpAutowried
    private IDemoService demoService;


    @GpRequestMapping("/query.json")
    public void query(HttpServletRequest req, HttpServletResponse resp,
                      @GpRequestParam("name") String name) {

        String result = demoService.getName();
        try {
            resp.getWriter().write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GpRequestMapping("/edit.json")
    public void edit(HttpServletRequest req, HttpServletResponse resp,
                     @GpRequestParam("id") Integer id) {

        String result = demoService.getName();
        try {
            resp.getWriter().write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GpRequestMapping("/remove.json")
    public void remove(HttpServletRequest req, HttpServletResponse resp,
                       @GpRequestParam("id") Integer id) {

        String result = demoService.getName();
        try {
            resp.getWriter().write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
