import { all, takeLatest } from "@redux-saga/core/effects";
import { signUpRequestSaga } from "./auth/signUpRequestSaga";
import { signUpRequest } from "../redux/auth/auth.actions";

export default function* root() {
  yield all([takeLatest(signUpRequest, signUpRequestSaga)]);
}
