package com.avin.kaplan.service;

import com.avin.kaplan.data.request.SignupRequest;
import com.avin.kaplan.data.response.UserResponse;
import com.avin.kaplan.model.oauth.ERole;
import com.avin.kaplan.model.oauth.Role;
import com.avin.kaplan.model.oauth.User;
import com.avin.kaplan.repository.RoleRepository;
import com.avin.kaplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;

//    public User updateUser(Long userId, User user) {
//        Optional<User> userDate = userRepository.findById(userId);
//        if (userDate.isPresent()) {
//            if (user.getUsername() != null)
//                userDate.get().setUsername(user.getUsername());
//            if (user.getEmail() != null)
//                userDate.get().setEmail(user.getEmail());
//            if (user.getPassword() != null)
//                userDate.get().setPassword(
//                        encoder.encode(user.getPassword()));
//            if (user.getAuthorities() != null)
//                userDate.get().setAuthorities(user.getAuthorities());
//        }
//        return userRepository.save(userDate.get());
//    }

    public User updateUser(Long userId, SignupRequest signUpForm) {
        Optional<User> userDate = userRepository.findById(userId);
        if (userDate.isPresent()) {
            if (signUpForm.getUsername() != null)
                userDate.get().setUsername(signUpForm.getUsername());
            if (signUpForm.getEmail() != null)
                userDate.get().setEmail(signUpForm.getEmail());
            if (signUpForm.getActive() != null)
                userDate.get().setActive(signUpForm.getActive());
            if (signUpForm.getStartTime() != null)
                userDate.get().setStartTime(signUpForm.getStartTime());
            if (signUpForm.getEndTime() != null)
                userDate.get().setEndTime(signUpForm.getEndTime());

            if (signUpForm.getPassword() != null)
                userDate.get().setPassword(
                        encoder.encode(signUpForm.getPassword()));
            if (signUpForm.getRoles() != null) {
                Set<Role> authorities = new HashSet<>();
                for (String roleString : signUpForm.getRoles()) {
                    Role role = new Role();
                    // TODO: 10/12/23
//                    role.setName(ERole.valueOf(roleString));
                    role.setName(ERole.valueOf(roleString));
                    authorities.add(role);
                }
                userDate.get().setAuthorities(authorities);
            }
        }
        Set<String> roles = signUpForm.getRoles();
        Set<Role> roleSet = new HashSet<>();
        for (String role:roles) {
            Role roleData = roleRepository.findByName(ERole.valueOf(role)).get();
            roleSet.add(roleData);
        }
        userDate.get().setAuthorities(roleSet);

        return userRepository.save(userDate.get());
    }

    public UserResponse findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return UserResponse.builder().status(Boolean.FALSE).build();
        }
        return UserResponse.builder()
                .status(Boolean.TRUE)
                .id(user.get().getId())
                .username(user.get().getUsername())
                .email(user.get().getEmail())
                .authorities(user.get().getAuthorities())
                .active(user.get().getActive())
                .startTime(user.get().getStartTime())
                .endTime(user.get().getEndTime())
                .build();
    }
}

