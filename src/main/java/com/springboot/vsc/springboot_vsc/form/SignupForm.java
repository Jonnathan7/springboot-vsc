package com.springboot.vsc.springboot_vsc.form;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class SignupForm {
    @NotBlank(message = "{require_check}" )
    @Email
    private String userId;
    @NotBlank
    @Length(min = 4, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$" )
    private String password;
    @NotBlank
    private String userName;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull
    private Date birthday;
    @Min(20)
    @Max(100)
    private Integer age;
    @NotNull
    private Integer gender;
}

