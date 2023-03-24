import path from "path";
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

const rootPath = path.resolve(__dirname, "..", "..");
const rootDir = path.resolve(rootPath, "modules");

export default defineConfig({
  root: rootPath,
  build: {
    rollupOptions: {
      input: {
        main: path.resolve(rootPath, "public", "index.html"),
      },
    },
    target: "esnext",
  },
  resolve: {
    alias: {
      "@core": path.resolve(rootDir, "core"),
      "@auth": path.resolve(rootDir, "auth"),
    },
  },
  server: {
    port: 8080,
  },
  plugins: [react()],
});
