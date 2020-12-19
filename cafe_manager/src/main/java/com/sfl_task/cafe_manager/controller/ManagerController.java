package com.sfl_task.cafe_manager.controller;

import com.sfl_task.cafe_manager.entity.*;
import com.sfl_task.cafe_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Autowired
    TableService tableService;

    @Autowired
    ProductService productService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager/manager");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView saveUser(@RequestParam("name") String name, @RequestParam("roleName") String roleName) {
        int role_id = 0;
        if (roleName.equals("manager")) {
            role_id = 1;
        } else {
            role_id = 2;
        }
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = new UserEntity();
        RoleEntity dummy = new RoleEntity(role_id, name);
        user.setRoleId(dummy);
        user.setName(name);
        userService.saveUser(user);
        modelAndView.setViewName("manager/manager");
        return modelAndView;
    }

    @RequestMapping(value = "/table/add", method = RequestMethod.POST)
    public ModelAndView saveTable(@RequestParam("status") String status, @RequestParam("waiter_id") int waiter_id) {
        UserEntity waiter = userService.findUserById(waiter_id).orElse(null);
        if (waiter == null) {

        } else {
            StatusEntity statusEntity = statusService.getStatusByName(status).orElse(null);
            TableEntity table = new TableEntity();
            table.setStatusId(statusEntity);
            table.setUserId(waiter);
            tableService.saveTable(table);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager/manager");
        return modelAndView;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ModelAndView saveProduct(@RequestParam("product") String product, @RequestParam("price") int price) {
        ModelAndView modelAndView = new ModelAndView();
        ProductEntity entity = new ProductEntity();
        entity.setName(product);
        entity.setPrice(price);
        productService.saveProduct(entity);
        modelAndView.setViewName("manager/manager");
        return modelAndView;
    }

    @RequestMapping(value = "/table/update", method = RequestMethod.POST)
    public ModelAndView addTaleToWaiter(@RequestParam("tableID") int tableID, @RequestParam("waiterId") int waiterId) {
        ModelAndView modelAndView = new ModelAndView();
        TableEntity tableEntity = tableService.findTableById(tableID).orElse(null);
        UserEntity userEntity = userService.findUserById(waiterId).orElse(null);
        if (tableEntity == null || userEntity == null) {
            modelAndView.addObject("incorrectData", "The inserted values is not correctly!!!");
        } else {
            RoleEntity roleEntity = roleService.getByRoleId(userEntity.getRoleId().getRoleId()).orElse(null);
            if(roleEntity.getName().equals("manager")) {
                modelAndView.addObject("incorrectUser", "The user is not a waiter!!!!");
            } else {
                tableEntity.setUserId(userEntity);
                tableService.saveTable(tableEntity);
            }
        }
        modelAndView.setViewName("manager/manager");
        return modelAndView;
    }
}