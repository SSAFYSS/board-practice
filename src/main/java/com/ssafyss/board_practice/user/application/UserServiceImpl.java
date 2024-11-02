package com.ssafyss.board_practice.user.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ssafyss.board_practice.user.infrastructure.UserRepository;
import com.ssafyss.board_practice.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean regist(UserRegistDto userDto) {
        if (userRepository.searchByEmail(userDto.getEmail()) != null) {
            return false;
        } else {
            String hashedPassword = passwordEncoder.encode(userDto.getPassword());
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(hashedPassword);
            user.setProfileImage(userDto.getProfileImage()); // 필요시 추가

            userRepository.insert(user);
            return true;
        }
    }

    @Override
    public boolean delete(String email) {
        int deleted = userRepository.delete(email);

        if(deleted > 0) {
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public User login(String email) {
        return userRepository.searchByEmail(email);
    }

}
