package com.sfl_task.cafe_manager.controller;

import com.sfl_task.cafe_manager.entity.*;
import com.sfl_task.cafe_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WaiterController {

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Autowired
    TableService tableService;

    @Autowired
    ProductService productService;

    @Autowired
    TableOrderService tableOrderService;

    @Autowired
    ProductInOrderService productInOrderService;

    @RequestMapping(value = "/getTables", method = RequestMethod.GET)
    public ModelAndView getWaiterTales(@RequestParam("waiterId") int waiterId) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity userById = userService.findUserById(waiterId).orElse(null);
        if (userById == null) {
            modelAndView.addObject("emptyList", "Users are not added yet!!!");
        }
        List<TableEntity> waiterTablesList = tableService.findUserByWaiterId(userById).orElse(null);
        if (waiterTablesList.isEmpty()) {
            modelAndView.addObject("NOTE", "The result of the query is 0");
        } else {
            modelAndView.addObject("NOTE1", "See the result of the request in the console )");
            for (TableEntity tableEntity : waiterTablesList) {
                System.out.println(" table list data: " + tableEntity);
            }
        }
        System.out.println(" table list count: " + waiterTablesList.size());
        modelAndView.setViewName("waiter/waiter");
        return modelAndView;
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public ModelAndView addOrder(@RequestParam("tableId") int tableId) {
        ModelAndView modelAndView = new ModelAndView();
        TableEntity table = tableService.findTableById(tableId).orElse(null);
        if (table != null) {
            StatusEntity statusEntity = statusService.getStatusById(table.getStatusId().getStatusId()).orElse(null);
            if (statusEntity.getName().equals("open")) {
                StatusEntity status = statusService.getStatusByName("closed").orElse(null);
                TableOrderEntity tableOrderEntity = new TableOrderEntity(status, table);
                tableOrderService.saveOrder(tableOrderEntity);
                tableService.saveTable(new TableEntity(tableId, table.getUserId(), status));
            }
        } else {
            modelAndView.addObject("tableError", "The table with such indexes does not exist!!!");
        }
        UserEntity user = new UserEntity();
        userService.saveUser(user);
        modelAndView.setViewName("waiter/waiter");
        return modelAndView;
    }

    @RequestMapping(value = "/productInOrder/add", method = RequestMethod.POST)
    public ModelAndView addProductInOrder(@RequestParam("status") String status,
                                          @RequestParam("productInOrderCount") int productInOrderCount,
                                          @RequestParam("productName") String productName) {
        StatusEntity statusEntity = statusService.getStatusByName(status).orElse(null);
        ProductEntity productEntity = productService.findProductByName(productName).orElse(null);
        ProductInOrderEntity productInOrderEntity = new ProductInOrderEntity(productEntity,
                statusEntity, productInOrderCount);
        productInOrderService.saveProductInOrder(productInOrderEntity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("waiter/waiter");
        return modelAndView;
    }

    @RequestMapping(value = "/productInOrder/update", method = RequestMethod.POST)
    public ModelAndView updateProductInOrder(@RequestParam("status") String status,
                                             @RequestParam("productInOrderCount") int productInOrderCount,
                                             @RequestParam("productName") String productName,
                                             @RequestParam("productInOrderId") int productInOrderId) {
        ModelAndView modelAndView = new ModelAndView();
        ProductInOrderEntity productInOrderEntity = productInOrderService.getProductInOrderById(productInOrderId).orElse(null);
        if (productInOrderEntity != null) {
            if (!status.isEmpty()) {
                StatusEntity statusEntity = statusService.getStatusByName(status).orElse(null);
                productInOrderEntity.setStatusId(statusEntity);
            }
            if (productInOrderCount != 0) {
                productInOrderEntity.setCount(productInOrderCount);
            }
            if (!productName.isEmpty()) {
                ProductEntity productEntity = productService.findProductByName(productName).orElse(null);
                productInOrderEntity.setProductId(productEntity);
            }
            productInOrderService.saveProductInOrder(productInOrderEntity);
        } else {
            modelAndView.addObject("productOrderError", "The inserted values is not correctly!!!");
        }
        modelAndView.setViewName("waiter/waiter");
        return modelAndView;
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    public ModelAndView updateOrder(@RequestParam("status") String status, @RequestParam("tableId") int tableId) {
        ModelAndView modelAndView = new ModelAndView();
        TableEntity tableEntity = tableService.findTableById(tableId).orElse(null);
        if (tableId != 0 && tableEntity != null) {
            StatusEntity statusEntity = statusService.getStatusByName(status).orElse(null);
            TableOrderEntity tableOrderEntity = tableOrderService.findByTableId(tableEntity).orElse(null);
            tableOrderEntity.setStatusId(statusEntity);
            tableOrderService.saveOrder(tableOrderEntity);
        } else {
            modelAndView.addObject("updateOrderError", "The inserted values is not correctly!!!");
        }
        modelAndView.setViewName("waiter/waiter");
        return modelAndView;
    }
}
