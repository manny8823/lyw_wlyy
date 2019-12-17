package com.example.demo1.controller;


import com.example.demo1.Dao.IndexDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "用户相关接口")
public class loginController {
    @Autowired
    private IndexDao indexDao;
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/index")
    public String login_to_login(){
        return "index";
    }

}
