package com.sirocu.sipoint.service;

import com.sirocu.sipoint.dto.User;
import com.sirocu.sipoint.entity.CredentialEntity;
import com.sirocu.sipoint.entity.RoleEntity;
import com.sirocu.sipoint.enums.LoginType;

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);
    RoleEntity getRoleName(String roleName);
    void verifyAccountKey(String key);
    void updateLoginAttempt(String email, LoginType loginType);
    User getUserByUserId(String userId);
    User getUserByEmail(String email);
    CredentialEntity getUserCredentialById(Long id);
}
