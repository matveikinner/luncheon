import { User } from "@auth/domain/models";
import AuthNetwork from "../models/auth/authNetwork";

export const toDomainUser = ({
  id,
  email,
  timeJoined,
}: AuthNetwork.AuthUser): User => ({
  id,
  email,
  timeJoined,
});
