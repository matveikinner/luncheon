import {
  defaultNS,
  resources,
} from "../modules/core/presentation/frameworks/i18next";

declare module "i18next" {
  interface CustomTypeOptions {
    defaultNS: typeof defaultNS;
    resources: typeof resources["en-US"];
  }
  type TranslationKeys = TFuncKey<CustomTypeOptions["resources"][]>;
}
