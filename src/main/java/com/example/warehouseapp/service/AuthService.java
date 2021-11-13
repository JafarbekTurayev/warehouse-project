package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.User;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.UserDto;
import com.example.warehouseapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByPhoneNumber(phone);
        return optionalUser.orElse(null);
    }

    public HttpEntity<?> editSmth(Integer id, UserDto userDto) {
        ApiResponse apiResponse = new ApiResponse();
        Optional<UserDto> optionalUserDto = userRepository.getById(id);
//        if (optionalUserDto.isPresent()) {
//            UserDto user = optionalUserDto.get();
//
//            if(!=null){
//
//            }
//            else{
//
//            }
//            if (!=null){
//
//            }else {
//
//            }
//            if (!=null) {
//
//            }else{
//
//            }
//            if(!=null){
//
//            }
//        }
        return ResponseEntity.EMPTY;
    }
}
