package com.ems.springsecurity.service;

import com.ems.springsecurity.dao.LoginDao;
import com.ems.springsecurity.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService, UserDetailsService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public List<Login> findAllLogin() {
        return loginDao.findAllLogin();
    }

    @Override
    public Login findLoginByEmail(String email) {
        return loginDao.findLoginByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        List<Login> list = findAllLogin();
        Optional<Login> login = list
                .stream()
                .filter(u -> u.getEmployee().getEmail().equals(s))
                .findAny();

        if (!login.isPresent()) {
            throw new UsernameNotFoundException("User doesnt not exist");
        }

        return User.withDefaultPasswordEncoder().username(login.get().getEmployee().getEmail())
                .password(login.get().getPassword())
                .roles(login.get().getEmployee().getDesignationId().getName()).build();
    }
}
