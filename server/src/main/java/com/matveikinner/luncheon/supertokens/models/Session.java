package com.matveikinner.luncheon.supertokens.models;

public record Session<T>(String handle, String userId, T userDataInJWT) {
}
