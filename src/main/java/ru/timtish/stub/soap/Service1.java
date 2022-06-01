package ru.timtish.stub.soap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.timtish.stub.service1._1.UploadRequest;

@Slf4j
@Endpoint("service1")
public class Service1 {

    public static final String NAMESPACE_URI = "urn://timtish.ru/stub/service1/1.0";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "upload")
    @ResponsePayload
    public Boolean upload(@RequestPayload UploadRequest r) {
        log.info("upload {} {} {} bytes", r.getInn(), r.getFileName(), r.getData() == null ? 0 : r.getData().length);
        return r.getData() != null && r.getData().length > 1024;
    }

}
