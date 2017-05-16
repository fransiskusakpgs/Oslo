package com.bliblifuture.controller;

import com.bliblifuture.model.Warehouse;
import com.bliblifuture.request.WarehouseRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
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
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @RequestMapping(value = "/api/warehouses", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse selectWarehouse(@RequestBody WarehouseRequest request){
        try {
            return new BaseResponse(warehouseService.changeWarehouseActive(request),"");
        } catch (Exception e){

            return new BaseResponse(false,e.getMessage());
        }
    }

    @RequestMapping(value = "/api/warehouses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<Warehouse> getAllWarehouse() {
        try {
            List<Warehouse> data = warehouseService.findWarehouseByAdmin();
            return new ListResponse<>(true, "", data);
        } catch (Exception e){
            return new ListResponse<>(false, e.getMessage(),null);
        }
    }
}
