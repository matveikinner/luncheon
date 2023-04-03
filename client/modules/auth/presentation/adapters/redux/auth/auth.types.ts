import { User } from "@auth/domain/models";
import { ReduxRestMeta } from "@core/domain/models";
import { AxiosError } from "axios";

export type AuthSignUpActionType =
  | "signUpRequest"
  | "signUpSuccess"
  | "signUpFailure";

export type AuthActionType = AuthSignUpActionType;

export type AuthMeta = ReduxRestMeta<AuthActionType | "idle", AxiosError>;

export type AuthState = {
  user: User | undefined;
  isAuthenticated: boolean;
  meta: AuthMeta;
};
