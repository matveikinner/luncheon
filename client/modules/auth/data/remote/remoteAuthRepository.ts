import { Observable, map } from "rxjs";
import { inject, injectable } from "inversify";
import AUTH_BINDINGS from "@auth/di/auth.bindings";
import { Credentials, User } from "@auth/domain/models";
import SuperTokensRepository from "@auth/domain/repositories/authRepository";
import AuthApi from "../network/api/authApi";
import { toDomainUser } from "../network/mappers/toDomainUser";

@injectable()
class RemoteAuthRepository implements SuperTokensRepository {
  @inject(AUTH_BINDINGS.AuthApi) private authApi!: AuthApi;

  signUp = (input: Credentials): Observable<User> =>
    this.authApi.signUp(input).pipe(map(({ user }) => toDomainUser(user)));
}

export default RemoteAuthRepository;
