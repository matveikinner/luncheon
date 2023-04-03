import { RequestMetaStatusEnum } from "@core/domain/models";
import { AxiosError } from "axios";
import { AuthActionType, AuthState } from "./auth.types";

export const AUTH_INITIAL_META: AuthState["meta"] = {
  status: RequestMetaStatusEnum.IDLE,
  action: "idle",
  isLoading: false,
  isError: false,
  error: undefined,
};

export const initialState: AuthState = {
  user: undefined,
  isAuthenticated: false,
  meta: AUTH_INITIAL_META,
};

export const generateAuthGenericRequestMeta = (
  action: AuthActionType | "idle"
): AuthState["meta"] => ({
  status: RequestMetaStatusEnum.PENDING,
  action,
  isLoading: true,
  isError: false,
  error: undefined,
});

export const generateAuthGenericSuccessMeta = (
  action: AuthActionType | "idle"
): AuthState["meta"] => ({
  status: RequestMetaStatusEnum.SUCCEEDED,
  action,
  isLoading: false,
  isError: false,
  error: undefined,
});

export const generateAuthGenericFailureMeta = (
  action: AuthActionType | "idle",
  error?: AxiosError
): AuthState["meta"] => ({
  status: RequestMetaStatusEnum.FAILED,
  action,
  isLoading: false,
  isError: true,
  error,
});
