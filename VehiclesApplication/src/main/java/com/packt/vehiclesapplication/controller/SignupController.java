package com.packt.vehiclesapplication.controller;

import com.packt.vehiclesapplication.domain.entity.User;
import com.packt.vehiclesapplication.domain.repository.UserRepository;
import com.packt.vehiclesapplication.dto.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRegisterDto dto) {
        if (dto.getPassword().length() < 8) {
            return ResponseEntity.badRequest().body("비밀번호는 최소 8자 이상이어야 합니다.");
        }

        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setAge(dto.getAge());
        user.setUserType(dto.getUserType());
        user.setAuthority(dto.getAuthorities());

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 사용자입니다.");
        }

        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}
