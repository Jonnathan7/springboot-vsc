package com.springboot.vsc.springboot_vsc.application.services;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    @Autowired
    private MessageSource messageSource;


    /** Generate a gender Map */
    public Map<String, Integer> getGenderMap() {
        Map<String, Integer> genderMap = new LinkedHashMap<>();
        String male = messageSource .getMessage("male" , null, Locale.ENGLISH );
        String female = messageSource .getMessage("female" , null, Locale.ENGLISH);

        genderMap.put(male, 1);
        genderMap.put(female, 2);
        return genderMap;
    }
}