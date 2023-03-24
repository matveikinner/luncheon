import { FunctionComponent } from "react";
import { Navigate } from "react-router-dom";
import ProtectedRouteProps from "./ProtectedRoute.types";

const ProtectedRoute: FunctionComponent<ProtectedRouteProps> = ({
  children,
  redirectPath,
  xor = false,
}: ProtectedRouteProps) => {
  // TODO: Auth context and context accessor
  const isAuthenticated = false;

  // XOR in reverse. In case we want to protect the route in reverse i.e. make it unaccessible when isAuthenticated
  // is true
  const shouldRedirect = !(
    (isAuthenticated && !xor) ||
    (!isAuthenticated && xor)
  );

  console.log("shouldRedirect", shouldRedirect);

  if (shouldRedirect) {
    return <Navigate to={redirectPath} replace />;
  }

  return <>{children}</>;
};

export default ProtectedRoute;
