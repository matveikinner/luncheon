import i18n, { InitOptions } from "i18next";
import LanguageDetector, {
  DetectorOptions,
} from "i18next-browser-languagedetector";
import { initReactI18next } from "react-i18next";
import { Locales_EN_US } from "./locales/en-US";
import { Locales_FI_FI } from "./locales/fi-FI";

const fallbackLng: AvailableLocales = "en-US";

const detection: DetectorOptions = {};

const parseMissingKeyHandler: InitOptions["parseMissingKeyHandler"] = (
  key: string,
  defaultValue?: string
) => "__i18n__";

export const defaultNS: AvailableLocales = "en-US";

export const resources = {
  "en-US": {
    ...Locales_EN_US,
  },
  "fi-FI": {
    ...Locales_FI_FI,
  },
};

export type AvailableLocales = keyof typeof resources;

i18n
  .use(LanguageDetector)
  .use(initReactI18next)
  .init({
    detection,
    interpolation: { escapeValue: true },
    fallbackLng,
    defaultNS,
    resources,
    parseMissingKeyHandler,
  })
  .then(() => {
    console.log("Success in attempt to initialise translations with i18Next");
  })
  .catch((err) => {
    console.error(
      "Error in attempt to initialise translations with i18Next",
      err
    );
  });

export default i18n;
