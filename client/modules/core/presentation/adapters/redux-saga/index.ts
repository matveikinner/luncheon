import authRootSaga from "@auth/presentation/adapters/redux-saga";
import { all } from "redux-saga/effects";

export default function* rootSaga() {
  yield all([authRootSaga()]);
}
