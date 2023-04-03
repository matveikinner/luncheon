package com.matveikinner.luncheon.supertokens.models;

public record JwtSigningPublicKey(String publicKey, long expiryTime, long createdAt) {
}
