package com.springboot.vsc.springboot_vsc.domain.user.service.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
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
    public void signup(MUser user) {
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");
        mapper.insertOne(user );
    }
    /** Get user */
    @Override
    public List<MUser> getUsers(MUser user) {
        return mapper.findMany(user );
    }
    /** Get user(1record) */
    @Override
    public MUser getUserOne(String userId) {
        return mapper.findOne(userId );
    }
    /** Update user */
    @Transactional
    @Override
    public void updateUserOne(String userId ,
        String password ,
        String userName) {
        mapper.updateOne(userId, password, userName);
        // Raise an exception for trx testing
        //int i = 1 / 0;
    }
    /** Delete user */
    @Override
    public void deleteUserOne(String userId) {
        int count = mapper.deleteOne(userId);
    }
}