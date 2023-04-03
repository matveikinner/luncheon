import { RootState } from "@core/presentation/frameworks/redux";
import { AuthState } from "./auth.types";

export const selectAuthState = (state: RootState): AuthState =>
  state.auth.authSlice;
