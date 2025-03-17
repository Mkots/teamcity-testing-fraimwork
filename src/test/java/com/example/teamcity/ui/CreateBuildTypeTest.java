package com.example.teamcity.ui;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.example.teamcity.api.models.BuildType;
import com.example.teamcity.api.models.Project;
import com.example.teamcity.api.requests.CheckedRequests;
import com.example.teamcity.api.spec.Specifications;
import com.example.teamcity.api.ui.pages.ProjectPage;
import com.example.teamcity.api.ui.pages.admin.CreateBuildTypePage;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.example.teamcity.api.enums.Endpoint.*;


@Test(groups = {"Regression", "UI"})
public class CreateBuildTypeTest extends BaseUiTest {
    private static final String REPO_URL = "https://github.com/MarySukhorukova/homework_18_API_II";
    @Test(description = "User should be able to create BuildType", groups = {"Positive"})
    public void userCreatesBuildType() {
        loginAs(testData.getUser());
        var userCheckRequests = new CheckedRequests(Specifications.authSpec(testData.getUser()));
        var createProject = userCheckRequests.<Project>getRequest(PROJECTS).create(testData.getProject());
        var projectId = createProject.getId();

        CreateBuildTypePage.open(projectId)
                .createForm(REPO_URL)
                .setupBuild(testData.getProject().getName(), testData.getBuildType().getName());

        var createdBuildType = userCheckRequests.<BuildType>getRequest(BUILD_TYPES)
                .read("name:" + testData.getBuildType().getName());
        softy.assertNotNull(createdBuildType, "Build type was not created");
        softy.assertEquals(testData.getBuildType().getName(), createdBuildType.getName(), "Build type name is incorrect");

        ProjectPage.open(projectId);
        boolean isBuildPresent = $(Selectors.byText(testData.getBuildType().getName()))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .exists();
        softy.assertTrue(isBuildPresent, "Build type is not displayed in the UI");
    }

    @Test(description = "User should not be able to create BuildType without a name", groups = {"Negative"})
    public void userCannotCreateBuildTypeWithoutName() {
        loginAs(testData.getUser());
        var userCheckRequests = new CheckedRequests(Specifications.authSpec(testData.getUser()));
        var createProject = userCheckRequests.<Project>getRequest(PROJECTS).create(testData.getProject());
        var projectId = createProject.getId();

        CreateBuildTypePage.open(projectId)
                .createForm(REPO_URL)
                .setupBuild(testData.getProject().getName(), "");

        String errorText = CreateBuildTypePage.getErrorMessage();
        softy.assertEquals(errorText, "Build configuration name must not be empty", "Error message is incorrect");

        ProjectPage.openSettings(projectId);
        softy.assertFalse(ProjectPage.isBuildTablePresent(), "Build configurations table should not be present when no builds exist");
    }
}

