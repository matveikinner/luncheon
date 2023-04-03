package com.matveikinner.luncheon.supertokens.dto;

import com.matveikinner.luncheon.supertokens.models.UserDataInDatabase;
import com.matveikinner.luncheon.supertokens.models.UserDataInJWT;

public record CreateSessionRequestDto(String userId, UserDataInJWT userDataInJWT, UserDataInDatabase userDataInDatabase,
                                      Boolean enableAntiCsrf) {
}
