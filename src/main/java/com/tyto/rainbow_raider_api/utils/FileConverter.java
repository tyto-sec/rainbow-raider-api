package com.tyto.rainbow_raider_api.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public interface FileConverter {

    static List<String> toList(MultipartFile file) throws IOException {
        return new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))
                .lines()
                .filter(line -> !line.trim().isEmpty())
                .toList();
    }

}
