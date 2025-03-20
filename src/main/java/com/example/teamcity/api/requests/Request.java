package com.example.teamcity.api.requests;

import lombok.Getter;
import com.example.teamcity.api.enums.Endpoint;
import io.restassured.specification.RequestSpecification;

@Getter
public class Request {
    /**
     * Request - это класс, описывающий меняющиеся параметры запроса, такие как:
     *  спецификация, эндпоинт (relative URL, model)
     */
    protected final RequestSpecification spec;
    protected final Endpoint endpoint;

    public Request(RequestSpecification spec, Endpoint endpoint) {
        this.spec = spec;
        this.endpoint = endpoint;
    }
    public Endpoint getEndpoint() {  // Явный геттер
        return endpoint;
    }
}
