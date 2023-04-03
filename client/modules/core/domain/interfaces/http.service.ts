import { AxiosInstance } from "axios";

export default interface IHttpService {
  get httpClient(): AxiosInstance;
  setHeader(header: string, value: string): void;
}
