import { Credentials, User } from "@auth/domain/models";
import { createAction } from "@reduxjs/toolkit";
import { AuthActionType } from "./auth.types";

export const signUpRequest = createAction<Credentials, AuthActionType>(
  "signUpRequest"
);

export const signUpSuccess = createAction<User, AuthActionType>(
  "signUpSuccess"
);

export const signUpFailure = createAction<string | void, AuthActionType>(
  "signUpFailure"
);
