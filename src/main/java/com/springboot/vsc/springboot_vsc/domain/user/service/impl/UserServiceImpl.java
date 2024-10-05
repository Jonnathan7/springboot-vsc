package com.springboot.vsc.springboot_vsc.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.vsc.springboot_vsc.domain.user.model.MUser;
import com.springboot.vsc.springboot_vsc.domain.user.service.UserService;
import com.springboot.vsc.springboot_vsc.repositories.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    /** User signup */
    @Override
    public void signup(MUser user ) {
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL" );
        mapper.insertOne(user );
    }
}