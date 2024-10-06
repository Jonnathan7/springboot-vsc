package com.springboot.vsc.springboot_vsc.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.vsc.springboot_vsc.domain.user.model.MUser;
import com.springboot.vsc.springboot_vsc.domain.user.service.UserService;
import com.springboot.vsc.springboot_vsc.form.UserDetailForm;
import com.springboot.vsc.springboot_vsc.form.UserListForm;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    /** User search */
    @GetMapping ("/get/list" )
    public List<MUser> getUserList(UserListForm form) {
        // Convert form to MUser class
        MUser user = modelMapper.map(form, MUser.class);
        // Get user list
        List<MUser> userList = userService.getUsers(user );
        return userList ;
    }

    /** Update user */
    @PutMapping("/update")
    public int updateUser(UserDetailForm form) {
        // Update user
        userService .updateUserOne(form.getUserId(),
        form.getPassword(),
        form.getUserName());
        return 0;
    }
    /** Delete user */
    @DeleteMapping ("/delete")
    public int deleteUser(UserDetailForm form) {
        // Delete user
        userService.deleteUserOne(form.getUserId());
        return 0;
    }
}
