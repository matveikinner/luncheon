package com.matveikinner.luncheon.auth.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matveikinner.luncheon.auth.model.AuthProviderType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AuthProvider")
@Table(name = "auth_provider")
public class AuthProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "provider_user_id")
    private String providerUserId;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private AuthProviderType provider;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
