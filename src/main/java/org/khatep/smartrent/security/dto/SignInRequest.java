package org.khatep.smartrent.security.dto;

import lombok.Builder;
import lombok.Data;
import org.khatep.smartrent.domain.enums.Role;

@Data
@Builder
public class SignInRequest {

    private String username;

    private String password;

    private Role role;
}