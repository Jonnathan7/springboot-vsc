package com.springboot.vsc.springboot_vsc.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.vsc.springboot_vsc.domain.user.model.MUser;
import com.springboot.vsc.springboot_vsc.domain.user.service.UserService;
import com.springboot.vsc.springboot_vsc.form.UserDetailForm;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping ("/user" )
@Slf4j
public class UserDetailController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    /** Display user details screen */
    @GetMapping("/detail/{userId:.+}")
    public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {
        // Get user
        MUser user = userService.getUserOne(userId );
        user.setPassword(null);

        // Convert MUser to form
        form = modelMapper.map(user, UserDetailForm.class);
        form.setSalaryList(user.getSalaryList());

        // Get user
        form = modelMapper.map(user , UserDetailForm.class);
        // Registered in Model
        model.addAttribute("userDetailForm", form);
        // Display user details screen
        return "user/detail";
    }
    /** User update process */
    @PostMapping(value = "/detail", params = "update")
    public String updateUser(UserDetailForm form , Model model ) {

        try {
            // Update user
            userService .updateUserOne(form.getUserId(),
                form .getPassword(),
                form .getUserName());            
        } catch (Exception e ) {
            log .error("Error in user update" , e );
        }
        
        // Redirect to user list screen
        return "redirect:/user/list";
    }
    /** User delete process */
    @PostMapping(value = "/detail", params = "delete" )
    public String deleteUser(UserDetailForm form , Model model ) {
        // Delete user
        userService .deleteUserOne(form.getUserId());
        // Redirect to user list screen
        return "redirect:/user/list";
    }

}
