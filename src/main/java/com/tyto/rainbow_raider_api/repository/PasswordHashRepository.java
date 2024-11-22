package com.tyto.rainbow_raider_api.repository;

import com.tyto.rainbow_raider_api.model.PasswordHash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordHashRepository extends JpaRepository<PasswordHash, Long> {
    Optional<PasswordHash> findByMd5Hash(String hash);
    Optional<PasswordHash> findBySha1Hash(String hash);
    Optional<PasswordHash> findBySha256Hash(String hash);
    Optional<PasswordHash> findBySha512Hash(String hash);
    Optional<PasswordHash> findByPassword(String password);
}
