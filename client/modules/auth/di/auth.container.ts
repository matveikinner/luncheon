import AuthApi from "@auth/data/network/api/authApi";
import RemoteAuthRepository from "@auth/data/remote/remoteAuthRepository";
import AuthRepositoryImpl from "@auth/data/authRepositoryImpl";
import AUTH_BINDINGS from "@auth/di/auth.bindings";
import AuthRepository from "@auth/domain/repositories/authRepository";
import SignUpUseCase from "@auth/domain/usecases/signUpUseCase";
import coreContainer from "@core/di/core.container";
import { Container } from "inversify";

const container = new Container();

container.parent = coreContainer;

container
  .bind<AuthRepository>(AUTH_BINDINGS.AuthRepository)
  .to(AuthRepositoryImpl);
container
  .bind<AuthRepository>(AUTH_BINDINGS.RemoteAuthRepository)
  .to(RemoteAuthRepository);
container.bind<AuthApi>(AUTH_BINDINGS.AuthApi).to(AuthApi);

container.bind<SignUpUseCase>(AUTH_BINDINGS.SignUpUseCase).to(SignUpUseCase);

export default container;
