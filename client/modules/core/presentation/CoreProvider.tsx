import { FunctionComponent, ReactNode } from "react";
import { BrowserRouter } from "react-router-dom";

const CoreProvider: FunctionComponent<{ children: ReactNode }> = ({
  children,
}) => <BrowserRouter>{children}</BrowserRouter>;

export default CoreProvider;
