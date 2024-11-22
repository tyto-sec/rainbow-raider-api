package com.tyto.rainbow_raider_api.fixture;

import com.tyto.rainbow_raider_api.model.PasswordHash;

public interface PasswordHashFixture {

        static PasswordHash builderDefault() {
            return builder().build();
        }

        private static PasswordHash.PasswordHashBuilder builder() {
            return PasswordHash.builder()
                    .password("secret")
                    .md5Hash("md5Hash")
                    .sha1Hash("sha1Hash")
                    .sha256Hash("sha256Hash")
                    .sha512Hash("sha512Hash");
        }
}
