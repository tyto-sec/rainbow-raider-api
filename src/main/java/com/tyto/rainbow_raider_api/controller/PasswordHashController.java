package com.tyto.rainbow_raider_api.controller;

import com.tyto.rainbow_raider_api.service.PasswordHashService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class PasswordHashController {

    private final PasswordHashService passwordHashService;

    @PostMapping("/wordlist/upload")
    public ResponseEntity<String> uploadWordlist(@RequestParam("file") MultipartFile file) {
        String response = passwordHashService.uploadWordlist(file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/md5/{hash}")
    public ResponseEntity<String> findByMd5Hash(@PathVariable String hash) {
        String response = passwordHashService.findByMd5Hash(hash);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sha1/{hash}")
    public ResponseEntity<String> findBySha1Hash(@PathVariable String hash) {
        String response = passwordHashService.findBySha1Hash(hash);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sha256/{hash}")
    public ResponseEntity<String> findBySha256Hash(@PathVariable String hash) {
        String response = passwordHashService.findBySha256Hash(hash);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sha512/{hash}")
    public ResponseEntity<String> findBySha512Hash(@PathVariable String hash) {
        String response = passwordHashService.findBySha512Hash(hash);
        return ResponseEntity.ok(response);
    }
}
