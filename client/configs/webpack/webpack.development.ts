import path from "path";
import { Configuration as WebpackConfiguration } from "webpack";
import { Configuration as WebpackDevServerConfiguration } from "webpack-dev-server";
import HtmlWebpackPlugin from "html-webpack-plugin";

const rootPath = path.resolve(__dirname, "..", "..");
const rootDir = path.resolve(rootPath, "modules");

const devServer: WebpackDevServerConfiguration = {
  historyApiFallback: true,
  hot: true,
  https: false,
  liveReload: true,
  open: true,
  port: 8080,
};

const webpackConfig = (): WebpackConfiguration => ({
  mode: "development",
  entry: path.resolve(rootDir, "index.tsx"),
  context: rootPath,
  resolve: {
    extensions: [".js", ".jsx", ".ts", ".tsx"],
    alias: {
      "@core": path.resolve(rootDir, "core"),
      "@auth": path.resolve(rootDir, "auth"),
      "@home": path.resolve(rootDir, "home"),
    },
  },
  output: {
    path: path.resolve(rootPath, "dist"),
    filename: "bundle.js",
    libraryTarget: "umd",
    libraryExport: "default",
  },
  devtool: "source-map",
  module: {
    rules: [
      {
        test: /\.(js|jsx|ts|tsx)$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
        },
      },
      {
        test: /\.css$/i,
        use: [
          { loader: "style-loader" },
          { loader: "css-loader", options: { url: false } },
        ],
      },
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: path.resolve(rootPath, "public", "index.html"),
    }),
  ],
  devServer,
});

export default webpackConfig;