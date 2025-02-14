package com.example.teamcity;

import com.example.teamcity.api.spec.Specifications;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import com.example.teamcity.api.models.User;

public class DummyTest extends BaseApiTest {
    @Test
    public void userShouldBeAbleGetAllProjects() {
        RestAssured
                .given()
                .spec(Specifications.getSpec().authSpec(User.builder().username("admin").password("admin").build()))
                .get("/app/rest/projects");
    }
}
