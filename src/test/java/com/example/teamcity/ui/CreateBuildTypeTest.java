package com.example.teamcity.ui;


import com.example.teamcity.api.models.Project;
import com.example.teamcity.api.requests.CheckedRequests;
import com.example.teamcity.api.spec.Specifications;
import org.testng.annotations.Test;

import static com.example.teamcity.api.enums.Endpoint.PROJECTS;
import static com.example.teamcity.api.enums.Endpoint.USERS;


@Test(groups = {"Regression", "UI"})
public class CreateBuildTypeTest extends BaseUiTest {
    @Test(description = "User should be able to create BuildType", groups = {"Positive"})
    public void userCreatesBuildType() {
        // создать проект на уровне апи
        superUserCheckRequests.getRequest(USERS).create(testData.getUser());
        var userCheckRequests = new CheckedRequests(Specifications.authSpec(testData.getUser()));
        var createProject = userCheckRequests.<Project>getRequest(PROJECTS).create(testData.getProject());
        var projectID = createProject.getId();
        System.out.println(projectID);

        // логинимся
        loginAs(testData.getUser());
        // Затем откройте страницу создания билда http://localhost:8111/admin/createObjectMenu.html?projectId={projectId}&showMode=createBuildTypeMenu

        // Создать билд

        // Проверить в апи билд

        // проверить в ui билд
    }
}
