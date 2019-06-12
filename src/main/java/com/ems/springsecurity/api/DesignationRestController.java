package com.ems.springsecurity.api;

import com.ems.springsecurity.model.Designation;
import com.ems.springsecurity.service.DesignationService;
import com.ems.springsecurity.utils.JSONUtils;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/designation/*")
public class DesignationRestController {

    @Autowired
    private ApplicationContext context;
    @SuppressWarnings("FieldCanBeLocal")
    private DesignationService designationService;

    @RequestMapping(value = "/read/all", method = RequestMethod.GET)
    public ResponseEntity readAllDesignations() {
        designationService = (DesignationService) context.getBean("designationService");
        List<Designation> list = designationService.findAllDesignations();
        ObjectNode objectNode = new JSONUtils().addArrayNode("content", list);
        return ResponseEntity.status(HttpStatus.OK).body(objectNode);
    }
}
