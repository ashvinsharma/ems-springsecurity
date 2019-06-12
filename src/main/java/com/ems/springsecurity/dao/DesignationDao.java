package com.ems.springsecurity.dao;

import com.ems.springsecurity.model.Designation;

import java.util.List;

public interface DesignationDao {
    List<Designation> findAllDesignations();

    Designation findDesignation(String designation);
}
