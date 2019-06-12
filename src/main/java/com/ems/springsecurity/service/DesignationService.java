package com.ems.springsecurity.service;

import com.ems.springsecurity.model.Designation;

import java.util.List;

public interface DesignationService {
    List<Designation> findAllDesignations();

    Designation findDesignation(String designation);
}
