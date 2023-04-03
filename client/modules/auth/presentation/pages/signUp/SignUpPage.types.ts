import { TFunction } from "i18next";
import { RegisterOptions, UseControllerProps } from "react-hook-form";
import { TextInputProps } from "flowbite-react";

export type SignUpPageFormFields = {
  email: string;
  password: string;
};

export type SignUpPageFormFieldsType = {
  fieldKey: UseControllerProps<SignUpPageFormFields>["name"];
  label: string | ReturnType<TFunction<"pages", "signUpPage">>;
  inputType: "text";
  inputProps?: TextInputProps;
  options?: RegisterOptions;
  customValidateFn?: (input: unknown) => boolean;
  customDependencyFn?: (args: unknown) => boolean;
};
