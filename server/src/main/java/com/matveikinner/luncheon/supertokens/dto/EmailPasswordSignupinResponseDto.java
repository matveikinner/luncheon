package com.matveikinner.luncheon.supertokens.dto;

import com.matveikinner.luncheon.supertokens.models.User;

public record EmailPasswordSignupinResponseDto(String status, User user) {
}
