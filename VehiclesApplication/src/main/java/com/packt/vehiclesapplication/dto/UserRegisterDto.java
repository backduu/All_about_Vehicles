package com.packt.vehiclesapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserRegisterDto {
    @NotBlank(message = "아이디는 필수 항목입니다.")
    @Size(min = 2, max = 30, message = "아이디는 2자 이상, 30자 이하여야 합니다.")
    private String id;

    @NotBlank(message = "이름은 필수 항목입니다.")
    @Size(min = 2, max = 30, message = "이름은 2자 이상, 30자 이하여야 합니다.")
    private String username;

    private String age;

    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하여야 합니다.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$",
            message = "비밀번호는 숫자, 대문자, 소문자, 특수문자를 포함해야 하며, 8자 이상 20자 이하여야 합니다."
    )
    private String password;

    private String userType;

    private List<String> authorities;
}