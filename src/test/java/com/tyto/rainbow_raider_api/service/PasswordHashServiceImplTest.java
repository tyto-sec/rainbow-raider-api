package com.tyto.rainbow_raider_api.service;

import com.tyto.rainbow_raider_api.fixture.PasswordHashFixture;
import com.tyto.rainbow_raider_api.service.impl.PasswordHashServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.tyto.rainbow_raider_api.model.PasswordHash;
import com.tyto.rainbow_raider_api.repository.PasswordHashRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;
import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PasswordHashServiceImplTest {

    @Mock
    private PasswordHashRepository repository;

    @InjectMocks
    private PasswordHashServiceImpl service;


    @Test
    void testUploadWordlistSuccess() throws IOException {
        String content = "password1\npassword2\npassword3";
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "wordlist.txt",
                "text/plain",
                content.getBytes()
        );

        when(repository.findByPassword("password1")).thenReturn(Optional.empty());
        when(repository.findByPassword("password2")).thenReturn(Optional.empty());
        when(repository.findByPassword("password3")).thenReturn(Optional.empty());

        String response = service.uploadWordlist(mockFile);

        assertEquals("Wordlist uploaded successfully", response);

        verify(repository, times(1)).saveAll(anyList());
    }

    @Test
    void testUploadWordlistErrorReadingFile() throws IOException {
        MockMultipartFile mockFile = mock(MockMultipartFile.class);
        when(mockFile.getInputStream()).thenThrow(IOException.class);

        String response = service.uploadWordlist(mockFile);

        assertEquals("Error reading file", response);
    }

    @Test
    void testFindByMd5HashFound() {
        PasswordHash passwordHash = PasswordHashFixture.builderDefault();

        when(repository.findByMd5Hash("md5Hash")).thenReturn(Optional.of(passwordHash));

        String response = service.findByMd5Hash("md5Hash");

        assertEquals("secret", response);
    }

    @Test
    void testFindByMd5HashNotFound() {
        when(repository.findByMd5Hash("nonexistenthash")).thenReturn(Optional.empty());

        String response = service.findByMd5Hash("nonexistenthash");

        assertEquals("Hash not found", response);
    }

    @Test
    void testFindBySha1HashFound() {
        PasswordHash passwordHash = PasswordHashFixture.builderDefault();

        when(repository.findBySha1Hash("sha1Hash")).thenReturn(Optional.of(passwordHash));

        String response = service.findBySha1Hash("sha1Hash");

        assertEquals("secret", response);
    }

    @Test
    void testFindBySha1HashNotFound() {
        when(repository.findBySha1Hash("nonexistenthash")).thenReturn(Optional.empty());

        String response = service.findBySha1Hash("nonexistenthash");

        assertEquals("Hash not found", response);
    }

    @Test
    void testFindBySha256HashFound() {
        PasswordHash passwordHash = PasswordHashFixture.builderDefault();

        when(repository.findBySha256Hash("sha256Hash")).thenReturn(Optional.of(passwordHash));

        String response = service.findBySha256Hash("sha256Hash");

        assertEquals("secret", response);
    }

    @Test
    void testFindBySha256HashNotFound() {
        when(repository.findBySha256Hash("nonexistenthash")).thenReturn(Optional.empty());

        String response = service.findBySha256Hash("nonexistenthash");

        assertEquals("Hash not found", response);
    }

    @Test
    void testFindBySha512HashFound() {
        PasswordHash passwordHash = PasswordHashFixture.builderDefault();

        when(repository.findBySha512Hash("sha512Hash")).thenReturn(Optional.of(passwordHash));

        String response = service.findBySha512Hash("sha512Hash");

        assertEquals("secret", response);
    }

    @Test
    void testFindBySha512HashNotFound() {
        when(repository.findBySha512Hash("nonexistenthash")).thenReturn(Optional.empty());

        String response = service.findBySha512Hash("nonexistenthash");

        assertEquals("Hash not found", response);
    }
}
