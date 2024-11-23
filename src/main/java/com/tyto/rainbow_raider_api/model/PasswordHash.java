package com.tyto.rainbow_raider_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "passwords_hashes")
public class PasswordHash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false, unique = true, length = 32, name="md5_hash")
    private String md5Hash;

    @Column(nullable = false, unique = true, length = 40, name = "sha1_hash")
    private String sha1Hash;

    @Column(nullable = false, unique = true, length = 64, name = "sha256_hash")
    private String sha256Hash;

    @Column(nullable = false, unique = true, length = 128, name = "sha512_hash")
    private String sha512Hash;

}
