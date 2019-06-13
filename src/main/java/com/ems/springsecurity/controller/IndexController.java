package com.ems.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "/record"})
    @Secured({"ROLE_IT", "ROLE_HR", "ROLE_SDE I", "ROLE_SDE II"})
    public String getIndex() {
        return "record_manipulate";
    }


    @RequestMapping("/record/create")
    @Secured({"ROLE_HR"})
    public String getCreatePage() {
        return "record_create.html";
    }

//    @RequestMapping
//    public ResponseEntity notFound() {
//        return ResponseEntity.status(404).body(new ObjectMapper()
//                .createObjectNode()
//                .put("content", "Service does not exist")
//        );
//    }
}
