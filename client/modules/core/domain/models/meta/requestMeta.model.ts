export enum RequestMetaStatusEnum {
  IDLE = "IDLE",
  PENDING = "PENDING",
  SUCCEEDED = "SUCCEEDED",
  FAILED = "FAILED",
}

interface ReduxRestMeta<T, E = unknown> {
  status: RequestMetaStatusEnum;
  action: T;
  isLoading: boolean;
  isError: boolean;
  error?: E;
}

export default ReduxRestMeta;
