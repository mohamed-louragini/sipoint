package com.sirocu.sipoint.repository;

import com.sirocu.sipoint.entity.ConfirmationEntity;
import com.sirocu.sipoint.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {
    Optional<ConfirmationEntity> findBykey(String key);
    Optional<ConfirmationEntity> findByUserEntity(UserEntity userEntity);
}
