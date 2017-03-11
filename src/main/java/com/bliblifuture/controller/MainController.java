package com.bliblifuture.controller;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.StockopnameRepository;
import com.bliblifuture.response.StockOpnameResponse;
import com.bliblifuture.response.StockOpnameResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS My Windows on 2/3/2017.
 */

@Controller
public class MainController {
//    @Autowired
//    StockopnameRepository stockopnameRepository;

//    @RequestMapping("/stockopname")
//    public String herbs (Model model) {
//
//        List<StockOpname> Stockopname = stockopnameRepository.findByCategory(.HERBS);
//        model.addAttribute("StockOpname", Stockopname);
//
//        return "URLNYA BUKAN YA?";
//    }

    @RequestMapping(value="/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockOpnameResponses getAllData() {
        StockOpnameResponses stockOpnameResponses = new StockOpnameResponses();
        StockOpnameResponse stockOpnameOne = new StockOpnameResponse();
        stockOpnameOne.setSKU("ABAB");
        StockOpnameResponse stockOpnameTwo = new StockOpnameResponse();
        stockOpnameTwo.setSKU("BABA");
        StockOpnameResponse stockOpnameThree = new StockOpnameResponse();
        stockOpnameThree.setSKU("CACA");
        List<StockOpnameResponse> data = new ArrayList<StockOpnameResponse>();
        data.add(stockOpnameOne);
        data.add(stockOpnameTwo);
        data.add(stockOpnameThree);
        stockOpnameResponses.setData(data);
        return stockOpnameResponses;
    }



    @RequestMapping("/template")
    private String temp() {
        return "TEMPLATE_REACT_JS_BOOTSTRAP";
    }

    @RequestMapping("/indexdefault")
    private String lalala() {
        return "indexdefault";
    }

    @RequestMapping("/")
    private String react() {
        return "index";
    }


    @RequestMapping("/indexdiana")
    private String reacts() {
        return "apphtml";
    }

    @RequestMapping("/login")
    private String reactsss() {
        return "jsForLogin";
    }

    @RequestMapping("/adduser")
    private String addNewUser() {
        return "jsForAddUser";
    }

    @RequestMapping("/worklist")
    private String worklist() {
        return "jsForWorklist";
    }

    @RequestMapping("/detailworklist")
    private String detail() {
        return "jsForDetailWorklist";
    }




}
