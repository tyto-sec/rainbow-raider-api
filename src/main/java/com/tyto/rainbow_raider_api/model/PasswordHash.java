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

    @Column(nullable = false, unique = true, length = 32)
    private String md5Hash;

    @Column(nullable = false, unique = true, length = 40)
    private String sha1Hash;

    @Column(nullable = false, unique = true, length = 64)
    private String sha256Hash;

    @Column(nullable = false, unique = true, length = 128)
    private String sha512Hash;

}
