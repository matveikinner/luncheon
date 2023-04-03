import { FunctionComponent, ReactNode } from "react";
import { I18nextProvider } from "react-i18next";
import { BrowserRouter } from "react-router-dom";
import i18n from "./frameworks/i18next";
import { Provider } from "react-redux";
import store from "./frameworks/redux";

const CoreProvider: FunctionComponent<{ children: ReactNode }> = ({
  children,
}) => (
  <Provider store={store}>
    <BrowserRouter>
      <I18nextProvider i18n={i18n}>{children}</I18nextProvider>
    </BrowserRouter>
  </Provider>
);

export default CoreProvider;
