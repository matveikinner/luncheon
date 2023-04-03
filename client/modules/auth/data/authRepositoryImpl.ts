import AUTH_BINDINGS from "@auth/di/auth.bindings";
import { Credentials, User } from "@auth/domain/models";
import AuthRepository from "@auth/domain/repositories/authRepository";
import { inject, injectable } from "inversify";
import { Observable } from "rxjs";

@injectable()
class AuthRepositoryImpl implements AuthRepository {
  @inject(AUTH_BINDINGS.RemoteAuthRepository)
  private remoteAuthRepository!: AuthRepository;

  signUp = (input: Credentials): Observable<User> =>
    this.remoteAuthRepository.signUp(input);
}

export default AuthRepositoryImpl;
