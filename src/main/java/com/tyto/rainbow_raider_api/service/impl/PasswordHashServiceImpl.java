package com.tyto.rainbow_raider_api.service.impl;

import com.tyto.rainbow_raider_api.model.PasswordHash;
import com.tyto.rainbow_raider_api.model.enums.Algorithm;
import com.tyto.rainbow_raider_api.repository.PasswordHashRepository;
import com.tyto.rainbow_raider_api.service.PasswordHashService;
import com.tyto.rainbow_raider_api.utils.FileConverter;
import com.tyto.rainbow_raider_api.utils.HashBuilder;
import com.tyto.rainbow_raider_api.utils.impl.HashBuilderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordHashServiceImpl implements PasswordHashService {

    private final PasswordHashRepository repository;

    @Override
    public String uploadWordlist(MultipartFile file) {
        List<String> wordlist;

        try{
             wordlist = FileConverter.toList(file);
        } catch (IOException e) {
            return "Error reading file";
        }

        List<PasswordHash> passwordHashes = wordlist.stream()
                .filter(password -> repository.findByPassword(password).isEmpty())
                .map(password -> {
                    HashBuilder hashBuilder = new HashBuilderImpl();
                    return PasswordHash.builder()
                            .password(password)
                            .md5Hash(hashBuilder.withAlgorithm(Algorithm.MD5).build(password))
                            .sha1Hash(hashBuilder.withAlgorithm(Algorithm.SHA1).build(password))
                            .sha256Hash(hashBuilder.withAlgorithm(Algorithm.SHA256).build(password))
                            .sha512Hash(hashBuilder.withAlgorithm(Algorithm.SHA512).build(password))
                            .build();
                })
                .toList();

        repository.saveAll(passwordHashes);

        return "Wordlist uploaded successfully";
    }

    @Override
    public String findByMd5Hash(String hash) {
        Optional<PasswordHash> passwordHash = repository.findByMd5Hash(hash);
        return getPassword(passwordHash);
    }

    @Override
    public String findBySha1Hash(String hash) {
        Optional<PasswordHash> passwordHash = repository.findBySha1Hash(hash);
        return getPassword(passwordHash);
    }

    @Override
    public String findBySha256Hash(String hash) {
        Optional<PasswordHash> passwordHash = repository.findBySha256Hash(hash);
        return getPassword(passwordHash);
    }

    @Override
    public String findBySha512Hash(String hash) {
        Optional<PasswordHash> passwordHash = repository.findBySha512Hash(hash);
        return getPassword(passwordHash);
    }

    private String getPassword(Optional<PasswordHash> passwordHash) {
        if (passwordHash.isPresent()) {
            return passwordHash.get().getPassword();
        } else {
            return "Hash not found";
        }
    }

}
