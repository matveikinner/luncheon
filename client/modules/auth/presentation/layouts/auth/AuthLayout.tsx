import { FunctionComponent } from "react";
import { Link, Outlet } from "react-router-dom";

const AuthLayout: FunctionComponent = () => {
  return (
    <>
      <div>AuthLayout.tsx</div>
      <Link to="/auth/signup">Sign up</Link>
      <Link to="/auth/signin">Sign in</Link>
      <Outlet />
    </>
  );
};

export default AuthLayout;
