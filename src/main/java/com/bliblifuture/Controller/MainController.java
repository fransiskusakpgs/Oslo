package com.bliblifuture.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS My Windows on 2/3/2017.
 */

@Controller

public class MainController {

    @RequestMapping("/indexdefault")
    private String lalala() {
        return "indexdefault";
    }

    @RequestMapping("/")
    private String react() {
        return "index";
    }

}
