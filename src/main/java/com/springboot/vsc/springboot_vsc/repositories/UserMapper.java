package com.springboot.vsc.springboot_vsc.repositories;

import org.apache.ibatis.annotations.Mapper;
import com.springboot.vsc.springboot_vsc.domain.user.model.MUser;


@Mapper
public interface UserMapper {
    /** User signup */
    public int insertOne(MUser user);
}
