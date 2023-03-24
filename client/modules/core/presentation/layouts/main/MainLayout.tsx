import React, { FunctionComponent } from "react";
import { Outlet } from "react-router-dom";

const CoreLayout: FunctionComponent = () => {
  return <Outlet />;
};

export default CoreLayout;
