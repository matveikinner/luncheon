import HttpService from "@core/data/services/http.service";
import CORE_BINDINGS from "@core/di/core.bindings";
import { inject, injectable } from "inversify";
import { from, map, Observable, tap } from "rxjs";
import AuthNetwork from "../models/auth/authNetwork";

@injectable()
class AuthApi {
  @inject(CORE_BINDINGS.HttpService) private httpService!: HttpService;

  signUp = (
    input: AuthNetwork.SignUpOrInRequest
  ): Observable<AuthNetwork.SignUpResponse> =>
    from(
      this.httpService.httpClient.post<AuthNetwork.SignUpResponse>(
        "/api/auth/signup",
        input,
        {
          headers: {
            "X-API-Version": 1,
          },
        }
      )
    ).pipe(
      tap((response) => console.log(AuthApi.name, response)),
      map(({ data }) => data)
    );
}

export default AuthApi;
