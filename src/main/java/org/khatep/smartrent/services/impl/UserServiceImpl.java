package org.khatep.smartrent.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.khatep.smartrent.domain.models.User;
import org.khatep.smartrent.repositories.UserRepository;
import org.khatep.smartrent.services.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() throws UsernameNotFoundException {
        return this::getUserByUsername;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    private User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));
    }
}
