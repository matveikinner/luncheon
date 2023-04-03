package com.matveikinner.luncheon.supertokens.dto;

import com.matveikinner.luncheon.supertokens.models.User;

import java.util.Optional;

public record EmailPasswordSignUpOrInResponseDto(String status, Optional<User> user) {
}
