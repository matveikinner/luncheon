import React, { lazy, Suspense } from "react";
import { RouteObject } from "react-router-dom";
import ProtectedRoute from "@auth/presentation/guards/protectedRoute/ProtectedRoute";
import HomeLayout from "./layouts/home/HomeLayout";

const DashboardPage = lazy(() => import("./pages/dashboard/DashboardPage"));

export enum HomeModuleRoutes {
  ROOT = "/",
  DASHBOARD = "/dashboard",
}

const routes: RouteObject[] = [
  {
    path: HomeModuleRoutes.ROOT,
    element: (
      <ProtectedRoute redirectPath="/auth/signin">
        <HomeLayout />
      </ProtectedRoute>
    ),
    children: [
      {
        path: HomeModuleRoutes.DASHBOARD,
        element: (
          <Suspense>
            <DashboardPage />
          </Suspense>
        ),
      },
    ],
  },
];

export default routes;
