package com.ems.springsecurity.service;

import com.ems.springsecurity.model.Login;

import java.util.List;

public interface LoginService {
    List<Login> findAllLogin();

    Login findLoginByEmail(String email);
}
