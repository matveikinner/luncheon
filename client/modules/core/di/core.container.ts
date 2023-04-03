import HttpService from "@core/data/services/http.service";
import IHttpService from "@core/domain/interfaces/http.service";
import { Container } from "inversify";
import CORE_BINDINGS from "./core.bindings";

const container = new Container();

container
  .bind<IHttpService>(CORE_BINDINGS.HttpService)
  .to(HttpService)
  .inSingletonScope();

export default container;
