import { ReactNode } from "react";

type ProtectedRouteProps = {
  children: ReactNode;
  redirectPath: string;
  xor?: boolean;
};

export default ProtectedRouteProps;
