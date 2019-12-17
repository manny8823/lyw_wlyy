package com.example.demo1.controller;

import com.example.demo1.Entity.Customer;
import com.example.demo1.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Api(tags = "用户相关接口")
@Controller
public class IndexController {
    @Autowired
    private CustomerService customerService;

    //登陆
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    //显示所有数据
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/cusData")
    //@RequestMapping(value = "/search")
    //@Query(value = "select * from customer",nativeQuery = true)
    public String cusData(@ApiParam(value = "model",name = "传参",required = false) Model model,HttpServletRequest request){
        List<Customer> show = customerService.getCustomer();
        model.addAttribute("showall",show);
        //return "cusData";
        return "index";
    }

    //根据id查找内容
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/queryCustomer")
    public String queryCus(@ApiParam(value = "model",name = "传参",required = true)Model model,
                           @ApiParam(value = "model",name = "关键",required = true)String id){
        //Integer StoI = Integer.parseInt( id );
        List<Customer> query = customerService.getCustomerById(id);
        model.addAttribute("showall", query);//这里忘记改成showall了
        //return "cusData";
        return "index";
    }

    //增加记录
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/addPage")
    public String to_add(){return "addPage";}
   // @RequestMapping(value = "/addCustomer")

    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @PostMapping("/addCustomer")
    /*public ModelAndView addCustomer(Customer customer){
        customerService.addCustomer(customer);
        //日志记录
        return new ModelAndView("redirect:/index");
    }*/
    public String addCustomer(@ApiParam(value = "name",name = "姓名",required = true)@Param("name") String name,
                              @ApiParam(value = "sex",name = "性别",required = true)@Param("sex") String sex,
                              @ApiParam(value = "address",name = "地址",required = true)@Param("address") String address,
                              @ApiParam(value = "phone",name = "电话",required = true)@Param("phone") String phone){
        Customer customer = new Customer();
        customer.setNameCustomer(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setSex(sex);
        customerService.addCustomer(customer);
        //重定向
        return "redirect:/index";
    }

    //添加这句不报错
    @Transactional
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/deletePage")
    public String deleteCustomer(@ApiParam(value = "model",name = "传参",required = false)Model model,
                                 @ApiParam(value = "id",name = "id" ,required = true)String id){
        customerService.deleteCustomerById(id);
        List<Customer> show = customerService.getCustomer();
        model.addAttribute("showall", show);//查询结果返回给lathes
        return "redirect:/index";// 回到展示表格的地方 lathe.html
    }

    //修改数据
    //修改数据,传值给修改页面
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/alterPage")
    public String alterCustomer(@ApiParam(value = "model",name = "传参",required = false)Model model, String id){
        //为什么是修改第0个呢？
        Customer customer = customerService.getCustomerById(id).get(0);
        model.addAttribute("customer",customer);
        return "alterPage";//返回修改页面
    }

    //修改数据
    @ApiOperation(value = "",httpMethod = "POST",response = String.class)
    @RequestMapping(value = "/alterCustomer")
    public String alterCustomer(@ApiParam(value = "name",name = "姓名",required = true)@Param("name") String name,
                                @ApiParam(value = "sex",name = "性别",required = true)@Param("sex") String sex,
                                @ApiParam(value = "address",name = "地址",required = true)@Param("address") String address,
                                @ApiParam(value = "phone",name = "电话",required = true)@Param("phone") String phone){
        Customer customer = new Customer();
        customer.setNameCustomer(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setSex(sex);
        customerService.addCustomer(customer);
        //重定向
        return "redirect:/index";
    }
}
