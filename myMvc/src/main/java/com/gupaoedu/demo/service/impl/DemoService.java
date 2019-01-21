package com.gupaoedu.demo.service.impl;

import com.gupaoedu.demo.mvcframework.annotation.GpService;
import com.gupaoedu.demo.service.IDemoService;

/**
 * Created by robin on 19/1/21.
 */
@GpService
public class DemoService implements IDemoService {

    @Override
    public String getName() {
        return "My Name is God! ";
    }

}
