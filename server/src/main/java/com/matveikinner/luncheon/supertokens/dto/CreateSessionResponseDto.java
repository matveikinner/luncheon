package com.matveikinner.luncheon.supertokens.dto;

import com.matveikinner.luncheon.supertokens.models.JwtSigningPublicKey;
import com.matveikinner.luncheon.supertokens.models.Token;
import com.matveikinner.luncheon.supertokens.models.Session;

import java.util.List;

public record CreateSessionResponseDto<T>(String status, Session<T> session, Token accessToken, Token refreshToken,
                                          Token idRefreshToken, String jwtSigningPublicKey,
                                          long jwtSigningPublicKeyExpiryTime,
                                          List<JwtSigningPublicKey> jwtSigningPublicKeyList, String antiCsrfToken) {
}
