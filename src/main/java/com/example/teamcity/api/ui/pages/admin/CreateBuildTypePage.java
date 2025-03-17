package com.example.teamcity.api.ui.pages.admin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;


public class CreateBuildTypePage extends CreateBasePage {
    private static final String BUILD_TYPE_SHOW_MODE = "createBuildTypeMenu";
    private static final SelenideElement errorMessage = $(".error");

    public static CreateBuildTypePage open(String projectId) {
        return Selenide.open(CREATE_URL.formatted(projectId, BUILD_TYPE_SHOW_MODE), CreateBuildTypePage.class);
    }

    private SelenideElement buildTypeNameInput = $("#buildTypeName");

    public CreateBuildTypePage createForm(String url) {
        baseCreateForm(url);
        $("[name='createProject']");
        return this;
    }

    public void setupBuild(String projectName, String buildTypeName) {
        buildTypeNameInput.should(Condition.appear, Duration.ofSeconds(10));
        buildTypeNameInput.shouldBe(enabled, Duration.ofSeconds(10));
        buildTypeNameInput.click();
        buildTypeNameInput.clear();
        buildTypeNameInput.append(buildTypeName);
        submitButton.click();
    }
    public static String getErrorMessage() {
        return errorMessage.shouldHave(Condition.text("Build configuration name must not be empty")).text();
    }
}
