namespace AuthNetwork {
  enum AuthStatusEnum {
    OK = "OK",
  }

  export interface AuthUser {
    id: string;
    email: string;
    timeJoined: number;
  }

  export interface SignUpOrInRequest {
    email: string;
    password: string;
  }

  export interface SignUpResponse {
    status: AuthStatusEnum.OK;
    user: AuthUser;
  }
}

export default AuthNetwork;
