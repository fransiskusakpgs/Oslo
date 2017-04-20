package com.bliblifuture.controller;

import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;

import com.bliblifuture.request.*;

import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.response.SingleResponse;
import com.bliblifuture.service.ReportService;
import com.bliblifuture.service.StockOpnameService;
import com.bliblifuture.service.UserService;
import com.bliblifuture.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    ReportService reportService;
    @Autowired
    StockOpnameService stockOpnameService;
    @Autowired
    UserService userService;
    @Autowired
    WarehouseService warehouseService;

    @RequestMapping(value = "api/unknownSKUs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addUnknownSKU(@RequestBody UnknownSKURequest request) {
        stockOpnameService.addUnknownSKUtoList(request);
        BaseResponse responseBS = new BaseResponse(true,"");
        return responseBS;

    }

    @RequestMapping(value = "api/assignment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse assignStockOpname(@RequestBody AssignmentRequest request){
        stockOpnameService.assignStockOpname(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value ="/api/reports", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createReport(@RequestBody ReportRequest request){
        reportService.createReport(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "api/stockopnames", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createStockOpnames(@RequestBody StockOpnameRequest request) {
        stockOpnameService.createStockOpname(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse editUser(@RequestBody UserRequest request){
        if (request.getRole().equals("ROLE_ADMIN")){
            userService.editAdmin(request);
        }
        else if(request.getRole().equals("ROLE_COUNTER")){
            userService.editCounter(request);
        }
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value ="/api/reports", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SingleResponse findReport(@RequestParam String date){
        Report data = reportService.findReportByDate(date);
        SingleResponse response = new SingleResponse(true,"", data);
        return response;
    }


    @RequestMapping(value = "/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllStockOpname() {
        List<StockOpname> data = stockOpnameService.findAll();
        ListResponse<StockOpname> response = new ListResponse<>(true, "", data);
        return response;
    }

    @RequestMapping(value="/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<User> getAllUsers(){
        List<User> data= userService.findAll();
        ListResponse<User> response = new ListResponse<>(true,"",data);
        return response;
    }

    @RequestMapping(value = "/api/warehouses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<Warehouse> getAllWarehouse() {
        List<Warehouse> data = warehouseService.findAll();
        ListResponse<Warehouse> response = new ListResponse<>(true, "", data);
        return response;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse registerUser(@RequestBody UserRequest request){
        if(request.getRole().equals("ROLE_ADMIN")){
            userService.registerAdmin(request);
        } else if (request.getRole().equals("ROLE_COUNTER")) {
            userService.registerCounter(request);
        }

        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "/api/warehouses", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse selectWarehouse(@RequestBody WarehouseRequest request){
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "/api/assignments", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
             produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse unAssignStockOpname(@RequestBody AssignmentRequest request){
        stockOpnameService.unAssignStockOpname(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }
}
