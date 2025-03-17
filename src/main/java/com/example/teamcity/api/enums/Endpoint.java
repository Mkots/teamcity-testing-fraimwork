package com.example.teamcity.api.enums;

import com.example.teamcity.api.models.BaseModel;
import com.example.teamcity.api.models.BuildType;
import com.example.teamcity.api.models.Project;
import com.example.teamcity.api.models.User;
import lombok.Getter;

@Getter
public enum Endpoint {
    BUILD_TYPES("/app/rest/buildTypes", BuildType.class),
    PROJECTS("/app/rest/projects", Project.class),
    USERS("/app/rest/users", User.class);

    private final String url;
    @Getter
    private final Class<? extends BaseModel> modelClass;

    Endpoint(String url, Class<? extends BaseModel> modelClass) {
        this.url = url;
        this.modelClass = modelClass;
    }
    public Class<? extends BaseModel> getModelClass() {  // <-- Явно добавляем геттер
        return modelClass;
    }
    public String getUrl() {  // <-- Явно добавляем геттер для url
        return url;
    }
}
