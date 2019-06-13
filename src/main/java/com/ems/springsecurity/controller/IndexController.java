package com.ems.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getIndex() {
        return "record_manipulate";
    }

    @RequestMapping("/record")
    public String getRecordManipulationPage() {
        return "record_manipulate.html";
    }

    @RequestMapping("/record/create")
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
