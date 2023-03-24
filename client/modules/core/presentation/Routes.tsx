import React, { Suspense, lazy } from "react";
import { RouteObject } from "react-router-dom";
import authModuleRoutes from "@auth/presentation/Routes";
import homeModuleRoutes from "@home/presentation/Routes";

const MainLayout = lazy(() => import("./layouts/main/MainLayout"));

const NotFoundPage = lazy(() => import("./pages/notFound/NotFoundPage"));

export enum CoreModuleRoutes {
  ROOT = "/",
  NOT_FOUND = "*",
}

const routes: RouteObject[] = [
  {
    path: CoreModuleRoutes.ROOT,
    element: <MainLayout />,
    children: [...authModuleRoutes, ...homeModuleRoutes],
  },
  {
    path: CoreModuleRoutes.NOT_FOUND,
    element: (
      <Suspense>
        <NotFoundPage />
      </Suspense>
    ),
  },
];

export default routes;
