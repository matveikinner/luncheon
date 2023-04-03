import { FunctionComponent } from "react";
import { Namespace, TFunction } from "i18next";
import { useTranslation } from "react-i18next";
import { z } from "zod";
import {
  Controller,
  FieldError,
  LiteralUnion,
  RegisterOptions,
  SubmitHandler,
  get,
  useForm,
} from "react-hook-form";
import { useDispatch } from "react-redux";
import { Button, Checkbox, Label, TextInput } from "flowbite-react";
import {
  SignUpPageFormFields,
  SignUpPageFormFieldsType,
} from "./SignUpPage.types";
import { signUpRequest } from "@auth/presentation/adapters/redux/auth/auth.actions";
import { Credentials } from "@auth/domain/models";

const SignUpPage: FunctionComponent = () => {
  const I18N_NAMESPACE: Namespace = "pages";

  const { t } = useTranslation(I18N_NAMESPACE);

  const dispatch = useDispatch();

  const defaultFormValues: SignUpPageFormFields = { email: "", password: "" };

  const {
    formState: { errors },
    handleSubmit,
    control,
  } = useForm<SignUpPageFormFields>({ defaultValues: defaultFormValues });

  const formFields: SignUpPageFormFieldsType[] = [
    {
      fieldKey: "email",
      label: t([
        "signUpPage.text.form.fields.email.label",
        "signUpPage.text.form.fields.email.label",
      ]),
      inputType: "text",
      options: {
        min: 2,
        max: 24,
        required: true,
      },
      customValidateFn: (input) => z.string().email().safeParse(input).success,
    },
    {
      fieldKey: "password",
      label: t([
        "signUpPage.text.form.fields.password.label",
        "signUpPage.text.form.fields.password.label",
      ]),
      inputType: "text",
      options: {
        min: 16,
        max: 32,
        required: true,
      },
    },
  ];

  const displayErrorMessage = (
    fieldKey: SignUpPageFormFieldsType["fieldKey"],
    errorType: LiteralUnion<keyof RegisterOptions, string>
  ): ReturnType<TFunction<"pages", "signUpPage">> =>
    t([`signUpPage.text.form.validation.${fieldKey}.${errorType}`]);

  const onSubmit: SubmitHandler<SignUpPageFormFields> = ({ email, password }) =>
    dispatch(signUpRequest(new Credentials(email, password)));

  return (
    <div className="container max-w-screen-lg mx-auto">
      <form className="flex flex-col">
        {formFields.map(
          ({ fieldKey, label, inputProps, options, customValidateFn }) => (
            <Controller
              key={fieldKey}
              name={fieldKey}
              control={control}
              render={({ field: { value, onChange } }) => (
                <>
                  <div className="mb-2 block">
                    <Label htmlFor={fieldKey} value={label} />
                  </div>
                  <TextInput
                    id={fieldKey}
                    value={value}
                    onChange={(event) => onChange(event)}
                    color={
                      (get(errors, fieldKey) as FieldError | undefined) &&
                      displayErrorMessage(
                        fieldKey,
                        (get(errors, fieldKey) as FieldError).type
                      ) &&
                      "failure"
                    }
                    helperText={
                      (get(errors, fieldKey) as FieldError | undefined) &&
                      displayErrorMessage(
                        fieldKey,
                        (get(errors, fieldKey) as FieldError).type
                      )
                    }
                    {...inputProps}
                  />
                </>
              )}
              rules={{
                validate: customValidateFn,
                ...options,
              }}
            />
          )
        )}
        <div className="flex items-center gap-2">
          <Checkbox id="remember" />
          <Label htmlFor="remember">Remember me</Label>
        </div>
        <Button type="submit" onClick={handleSubmit(onSubmit)}>
          Submit
        </Button>
      </form>
    </div>
  );
};

export default SignUpPage;
