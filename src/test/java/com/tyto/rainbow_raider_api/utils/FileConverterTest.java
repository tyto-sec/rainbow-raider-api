package com.tyto.rainbow_raider_api.utils;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileConverterTest {

    @Test
    void testToListWithValidFile() throws IOException {
        String content = "password1\npassword2\npassword3";
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "wordlist.txt",
                "text/plain",
                content.getBytes()
        );

        List<String> result = FileConverter.toList(mockFile);

        assertEquals(3, result.size());
        assertEquals("password1", result.get(0));
        assertEquals("password2", result.get(1));
        assertEquals("password3", result.get(2));
    }

    @Test
    void testToListWithEmptyFile() throws IOException {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "empty.txt",
                "text/plain",
                "".getBytes()
        );

        List<String> result = FileConverter.toList(mockFile);

        assertTrue(result.isEmpty());
    }

    @Test
    void testToListWithNullFile() {
        assertThrows(NullPointerException.class, () -> FileConverter.toList(null));
    }

    @Test
    void testToListWithFileContainingEmptyLines() throws IOException {
        String content = "password1\n\npassword2\n\n";
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "wordlist_with_empty_lines.txt",
                "text/plain",
                content.getBytes()
        );

        List<String> result = FileConverter.toList(mockFile);

        assertEquals(2, result.size());
        assertEquals("password1", result.get(0));
        assertEquals("password2", result.get(1));
    }
}
