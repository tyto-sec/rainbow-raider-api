package com.tyto.rainbow_raider_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Algorithm {
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");

    private final String name;
}
