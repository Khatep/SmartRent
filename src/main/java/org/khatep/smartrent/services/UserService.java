package org.khatep.smartrent.services;

import org.khatep.smartrent.domain.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDetailsService userDetailsService() throws UsernameNotFoundException;

    User save(User user);
}
