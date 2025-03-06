package com.example.teamcity.api.ui.pages.admin;

import com.codeborne.selenide.Selenide;


public class CreateBuildTypePage extends CreateBasePage {
    private static final String BUILD_TYPE_SHOW_MODE = "createBuildTypeMenu";

    public static CreateProjectPage open(String projectId) {
        return Selenide.open(CREATE_URL.formatted(projectId, BUILD_TYPE_SHOW_MODE), CreateProjectPage.class);
    }
}
