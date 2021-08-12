package tests.api;

import BaseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import endpoints.UsersEndpoints;
import models.Project;
import models.ProjectTypes;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static javax.swing.UIManager.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getAllUsers(){
        String endpoint = "index.php?/api/v2/get_users";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUserDetailsTest (){
        int userID = 1;
        String endpoint = "index.php?/api/v2/get_user/%s";
        given()
                .when()
                .get(String.format(endpoint, userID))
                .then()
                .log().body()
                .body("name", is("Alex Tros"))
                .body("email", equalTo("atrostyanko+0606@gmail.com"))
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getAllUsersDetailsTest (){
        User user = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0606@gmail.com")
                .build();

        String endpoint = "index.php?/api/v2/get_users";
        given()
                .when()
                .get(UsersEndpoints.GET_USERS)
                .then()
                .log().body()
                .body("get(0).name", is(user.getName()))
                .body("get(0)email", equalTo(user.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest(){
        Project project = Project.builder()
                .name("PROJ")
                .suite_mode(ProjectTypes.SINGLE_SUITE_BASELINES)
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"suite_mode\": \"%d\"\n" +
                        "}", project.getName(), project.getSuite_mode()))
                        .when()
                        .post(ProjectEndpoints.ADD_PROJECT)
                        .then()
                        .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

}
