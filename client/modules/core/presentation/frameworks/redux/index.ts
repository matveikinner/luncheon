import authRootReducer from "@auth/presentation/adapters/redux";
import rootSaga from "@core/presentation/adapters/redux-saga";
import { configureStore, combineReducers } from "@reduxjs/toolkit";

import sagaMiddleware from "../redux-saga";

const rootReducer = combineReducers({
  auth: authRootReducer,
});

export type RootState = ReturnType<typeof rootReducer>;

export type AppDispatch = typeof store.dispatch;

const store = configureStore({
  reducer: rootReducer,
  middleware: [sagaMiddleware],
});

sagaMiddleware.run(rootSaga);

export default store;
