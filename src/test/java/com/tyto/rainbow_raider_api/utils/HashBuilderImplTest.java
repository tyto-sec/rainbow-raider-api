package com.tyto.rainbow_raider_api.utils;

import com.tyto.rainbow_raider_api.model.enums.Algorithm;
import com.tyto.rainbow_raider_api.utils.impl.HashBuilderImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HashBuilderImplTest {
    @Test
    void testMD5HashGeneration() {
        String hash = new HashBuilderImpl()
                .withAlgorithm(Algorithm.MD5)
                .build("secret");

        assertEquals("5ebe2294ecd0e0f08eab7690d2a6ee69", hash);
    }

    @Test
    void testSHA1HashGeneration() {
        String hash  = new HashBuilderImpl()
                .withAlgorithm(Algorithm.SHA1)
                .build("secret");

        assertEquals("e5e9fa1ba31ecd1ae84f75caaa474f3a663f05f4", hash);
    }

    @Test
    void testSHA256HashGeneration() {
        String hash = new HashBuilderImpl()
                .withAlgorithm(Algorithm.SHA256)
                .build("secret");

        assertEquals("2bb80d537b1da3e38bd30361aa855686bde0eacd7162fef6a25fe97bf527a25b", hash);
    }

    @Test
    void testSHA512HashGeneration() {
        String hash = new HashBuilderImpl()
                .withAlgorithm(Algorithm.SHA512)
                .build("secret");

        assertEquals("bd2b1aaf7ef4f09be9f52ce2d8d599674d81aa9d6a4421696dc4d93dd0619d682ce56b4d64a9ef097761ced99e0f67265b5f76085e5b0ee7ca4696b2ad6fe2b2", hash);
    }

    @Test
    void testAlgorithmNotSet() {
        HashBuilderImpl hashBuilder = new HashBuilderImpl();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> hashBuilder.build("secret")
        );

        assertEquals("A valid algorithm must be specified before building the hash.", exception.getMessage());
    }
}
