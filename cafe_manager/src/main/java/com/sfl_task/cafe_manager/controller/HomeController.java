package com.sfl_task.cafe_manager.controller;

import com.sfl_task.cafe_manager.entity.RoleEntity;
import com.sfl_task.cafe_manager.entity.StatusEntity;
import com.sfl_task.cafe_manager.service.RoleService;
import com.sfl_task.cafe_manager.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        if (statusService.getStatusCount() < 4) {
            statusService.saveStatus(new StatusEntity("open"));
            statusService.saveStatus(new StatusEntity("active"));
            statusService.saveStatus(new StatusEntity("closed"));
            statusService.saveStatus(new StatusEntity("cancelled"));
        }
        modelAndView.setViewName("home/home");
        return modelAndView;
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView manager() {
        if (roleService.getRolesCount() < 2) {
            roleService.saveRole(new RoleEntity("manager"));
            roleService.saveRole(new RoleEntity("waiter"));
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager/manager");
        return modelAndView;
    }

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public ModelAndView waiter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("waiter/waiter");
        return modelAndView;
    }

}
