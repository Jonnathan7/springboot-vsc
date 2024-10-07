package com.springboot.vsc.springboot_vsc.domain.user.service;

import java.util.List;
import com.springboot.vsc.springboot_vsc.domain.user.model.MUser;

public interface UserService {
     /** User signup */
     public void signup(MUser user);
     /** Get user */
     public List<MUser> getUsers(MUser user );
     /** Get user(1record) */
     public MUser getUserOne(String userId );
     /** Update user */
     public void updateUserOne(String userId ,
          String password ,
          String userName);
     /** Delete user */
     public void deleteUserOne(String userId);
}
