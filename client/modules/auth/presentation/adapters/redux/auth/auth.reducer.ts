import { createReducer } from "@reduxjs/toolkit";
import { signUpFailure, signUpRequest, signUpSuccess } from "./auth.actions";
import {
  generateAuthGenericFailureMeta,
  generateAuthGenericRequestMeta,
  generateAuthGenericSuccessMeta,
  initialState,
} from "./auth.constants";

export default createReducer(initialState, (builder) =>
  builder
    .addCase(signUpRequest, (state) => ({
      ...state,
      user: undefined,
      isAuthenticated: false,
      meta: generateAuthGenericRequestMeta("signUpRequest"),
    }))
    .addCase(signUpSuccess, (state, { payload: user }) => ({
      ...state,
      user,
      isAuthenticated: true,
      meta: generateAuthGenericSuccessMeta("signUpSuccess"),
    }))
    .addCase(signUpFailure, (state) => ({
      ...state,
      user: undefined,
      isAuthenticated: false,
      meta: generateAuthGenericFailureMeta("signUpFailure"),
    }))
);
