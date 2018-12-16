package com.gmail.stepan1983.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@Controller
public class ControllerBank {

    @Autowired
    DataSource dataSource;

    @RequestMapping("/")
    String index(){

        System.out.println(dataSource);

        return "index";
    }

}
