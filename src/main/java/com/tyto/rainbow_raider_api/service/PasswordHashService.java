package com.tyto.rainbow_raider_api.service;

import org.springframework.web.multipart.MultipartFile;

public interface PasswordHashService {
    String uploadWordlist(MultipartFile file);
    String findByMd5Hash(String hash);
    String findBySha1Hash(String hash);
    String findBySha256Hash(String hash);
    String findBySha512Hash(String hash);
}
