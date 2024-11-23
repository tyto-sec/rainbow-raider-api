package com.tyto.rainbow_raider_api.controller;

import com.tyto.rainbow_raider_api.service.PasswordHashService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PasswordHashControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordHashService passwordHashService;

    @Test
    void uploadWordlistTest() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "wordlist.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "password1\npassword2\npassword3".getBytes()
        );

        when(passwordHashService.uploadWordlist(mockFile)).thenReturn("Wordlist uploaded successfully");

        mockMvc.perform(multipart("/api/v1/wordlist")
                        .file(mockFile))
                .andExpect(status().isOk())
                .andExpect(content().string("Wordlist uploaded successfully"));
    }

    @Test
    void findByMd5HashTest() throws Exception {
        String hash = "md5Hash";
        when(passwordHashService.findByMd5Hash(hash)).thenReturn(hash);

        mockMvc.perform(get("/api/v1/md5/{hash}", hash))
                .andExpect(status().isOk())
                .andExpect(content().string(hash));
    }

    @Test
    void findByMd5HashNotFoundTest() throws Exception {
        String hash = "nonexistenthash";
        when(passwordHashService.findByMd5Hash(hash)).thenReturn("Hash not found");

        mockMvc.perform(get("/api/v1/md5/{hash}", hash))
                .andExpect(status().isOk())
                .andExpect(content().string("Hash not found"));
    }

    @Test
    void findBySha1HashTest() throws Exception {
        String hash = "sha1Hash";
        when(passwordHashService.findBySha1Hash(hash)).thenReturn(hash);

        mockMvc.perform(get("/api/v1/sha1/{hash}", hash))
                .andExpect(status().isOk())
                .andExpect(content().string(hash));
    }

    @Test
    void findBySha256HashTest() throws Exception {
        String hash = "sha256Hash";
        when(passwordHashService.findBySha256Hash(hash)).thenReturn(hash);

        mockMvc.perform(get("/api/v1/sha256/{hash}", hash))
                .andExpect(status().isOk())
                .andExpect(content().string(hash));
    }

    @Test
    void findBySha512HashTest() throws Exception {
        String hash = "sha512Hash";
        when(passwordHashService.findBySha512Hash(hash)).thenReturn(hash);

        mockMvc.perform(get("/api/v1/sha512/{hash}", hash))
                .andExpect(status().isOk())
                .andExpect(content().string(hash));
    }
}

