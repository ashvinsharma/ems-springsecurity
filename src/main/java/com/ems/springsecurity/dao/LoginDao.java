package com.ems.springsecurity.dao;

import com.ems.springsecurity.model.Login;

import java.util.List;

public interface LoginDao {
    List<Login> findAllLogin();

    Login findLoginByEmail(String email);
}
