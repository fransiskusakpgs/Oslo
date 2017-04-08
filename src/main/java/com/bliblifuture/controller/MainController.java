package com.bliblifuture.controller;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.request.UserRequest;
import com.bliblifuture.request.WarehouseRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.StockOpnameService;
import com.bliblifuture.service.UserService;
import com.bliblifuture.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    StockOpnameService stockOpnameService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllStockOpname() {
        List<StockOpname> data = stockOpnameService.findAll();
        ListResponse<StockOpname> response = new ListResponse<>(true, "", data);
        return response;
    }

    @RequestMapping(value = "/api/warehouses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<Warehouse> getAllWarehouse() {
        List<Warehouse> data = warehouseService.findAll();
        ListResponse<Warehouse> response = new ListResponse<>(true, "", data);
        return response;
    }

    @RequestMapping(value="/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<User> getAllUsers(){
        List<User> data = userService.findAll();
        ListResponse<User> response = new ListResponse<>(true,"", data);
        return response;
    }

    @RequestMapping(value = "/api/warehouses", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse selectWarehouse(@RequestBody WarehouseRequest request){
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse registerUser(@RequestBody UserRequest request){
        userService.registerAdmin(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }
}
