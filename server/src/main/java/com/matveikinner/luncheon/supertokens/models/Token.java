package com.matveikinner.luncheon.supertokens.models;

public record Token(String token, long expiry, long createdTime) {
}
