import AUTH_BINDINGS from "@auth/di/auth.bindings";
import { inject, injectable } from "inversify";
import { Credentials } from "../models";
import AuthRepository from "../repositories/authRepository";

@injectable()
class SignUpUseCase {
  @inject(AUTH_BINDINGS.AuthRepository) private authRepository!: AuthRepository;

  invoke = (input: Credentials) => this.authRepository.signUp(input);
}

export default SignUpUseCase;
