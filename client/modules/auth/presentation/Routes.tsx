import React, { lazy, Suspense } from "react";
import { RouteObject } from "react-router-dom";
import ProtectedRoute from "./guards/protectedRoute/ProtectedRoute";
import AuthLayout from "./layouts/auth/AuthLayout";

const SignUpPage = lazy(() => import("./pages/signUp/SignUpPage"));
const SignInPage = lazy(() => import("./pages/signIn/SignInPage"));

export enum AuthModuleRoutes {
  ROOT = "/auth",
  SIGN_UP = "/auth/signup",
  SIGN_IN = "/auth/signin",
}

const routes: RouteObject[] = [
  {
    path: AuthModuleRoutes.ROOT,
    element: (
      <ProtectedRoute redirectPath="/dashboard" xor={true}>
        <AuthLayout />
      </ProtectedRoute>
    ),
    children: [
      {
        path: AuthModuleRoutes.SIGN_UP,
        element: (
          <Suspense>
            <SignUpPage />
          </Suspense>
        ),
      },
      {
        path: AuthModuleRoutes.SIGN_IN,
        element: (
          <Suspense>
            <SignInPage />
          </Suspense>
        ),
      },
    ],
  },
];

export default routes;
