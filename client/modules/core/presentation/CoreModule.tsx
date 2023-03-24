import { FunctionComponent } from "react";
import { useRoutes } from "react-router-dom";
import coreModuleRoutes from "./Routes";

const CoreModule: FunctionComponent = () => useRoutes(coreModuleRoutes);

export default CoreModule;
