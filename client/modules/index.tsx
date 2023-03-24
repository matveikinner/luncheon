import { createRoot } from "react-dom/client";
import CoreModule from "./core/presentation/CoreModule";
import CoreProvider from "@core/presentation/CoreProvider";

const container = document.getElementById("root")!;
const root = createRoot(container);

root.render(
  <CoreProvider>
    <CoreModule />
  </CoreProvider>
);