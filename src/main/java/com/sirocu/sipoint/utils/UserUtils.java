package com.sirocu.sipoint.utils;

import com.sirocu.sipoint.dto.User;
import com.sirocu.sipoint.entity.CredentialEntity;
import com.sirocu.sipoint.entity.RoleEntity;
import com.sirocu.sipoint.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public final class UserUtils {

    @Value("${account.days.before.expire}")
    private static int daysBeforeExpire;

    private UserUtils() {}

    public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role) {
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .lastLogin(now())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .mfa(false)
                .enabled(false)
                .loginAttempts(0)
                .qrCodeSecret(EMPTY)
                .phone(EMPTY)
                .bio(EMPTY)
                .imageUrl("https://cdn-icons-png.flaticon.com/512/149/149071.png")
                .roles(role)
                .build();
    }


    public static User fromUserEntity(UserEntity userEntity, RoleEntity roles, CredentialEntity credentialEntity) {
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        user.setLastLogin(userEntity.getLastLogin().toString());
        user.setCredentialsNonExpired(isCredentialNonExpired(credentialEntity));
        user.setCreatedAt(userEntity.getCreatedAt().toString());
        user.setUpdatedAt(userEntity.getUpdatedAt().toString());
        user.setRole(roles.getName());
        user.setAuthorities(roles.getAuthorities().getValue());
        return user;
    }

    private static boolean isCredentialNonExpired(CredentialEntity credentialEntity) {
        return credentialEntity.getCreatedAt().plusDays(daysBeforeExpire).isAfter(now());
    }
}
