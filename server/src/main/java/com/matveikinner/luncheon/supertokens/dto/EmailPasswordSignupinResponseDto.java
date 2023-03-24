package com.matveikinner.luncheon.supertokens.dto;

import com.matveikinner.luncheon.supertokens.models.User;

import java.util.Optional;

public record EmailPasswordSignupinResponseDto(String status, Optional<User> user) {
}
