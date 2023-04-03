import AUTH_BINDINGS from "@auth/di/auth.bindings";
import authContainer from "@auth/di/auth.container";
import { Credentials, User } from "@auth/domain/models";
import SignUpUseCase from "@auth/domain/usecases/signUpUseCase";
import { PayloadAction } from "@reduxjs/toolkit";
import { put } from "redux-saga/effects";
import { lastValueFrom, Observable } from "rxjs";
import { signUpFailure, signUpSuccess } from "../../redux/auth/auth.actions";

export function* signUpRequestSaga({ payload }: PayloadAction<Credentials>) {
  const signUpUseCase = authContainer.get<SignUpUseCase>(
    AUTH_BINDINGS.SignUpUseCase
  );

  try {
    const user = (yield lastValueFrom(
      (yield signUpUseCase.invoke(payload)) as Observable<User>
    )) as User;

    yield put(signUpSuccess(user));
  } catch (err) {
    yield put(signUpFailure());
    throw err;
  }
}
