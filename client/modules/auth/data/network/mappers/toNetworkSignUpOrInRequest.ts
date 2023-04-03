import { Credentials } from "@auth/domain/models";
import AuthNetwork from "../models/auth/authNetwork";

declare module "@auth/domain/models/credentials/credentials.model" {
  interface Credentials {
    toNetworkSignUpOrIn(): AuthNetwork.SignUpOrInRequest;
  }
}

Credentials.prototype.toNetworkSignUpOrIn = function () {
  return {
    email: this.email,
    password: this.password,
  };
};
