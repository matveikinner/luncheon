import { FunctionComponent } from "react";
import { Link, Outlet } from "react-router-dom";

const HomeLayout: FunctionComponent = () => {
  return (
    <>
      <div>HomeLayout.tsx</div>
      <Outlet />
    </>
  );
};

export default HomeLayout;
