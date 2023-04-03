import { Observable } from "rxjs";
import { Credentials, User } from "../models";

interface AuthRepository {
  signUp(data: Credentials): Observable<User>;
}

export default AuthRepository;
