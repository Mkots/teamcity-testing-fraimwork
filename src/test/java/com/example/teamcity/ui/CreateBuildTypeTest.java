package com.example.teamcity.ui;


import org.testng.annotations.Test;


@Test(groups = {"Regression"})
public class CreateBuildTypeTest extends BaseUiTest {
    @Test(description = "User should be able to create BuildType", groups = {"Positive"})
    public void userCreatesBuildType() {
        // создать проект на уровне апи
        // Затем откройте страницу создания билда http://localhost:8111/admin/createObjectMenu.html?projectId={projectId}&showMode=createBuildTypeMenu
        // Создать билд
    }
}
