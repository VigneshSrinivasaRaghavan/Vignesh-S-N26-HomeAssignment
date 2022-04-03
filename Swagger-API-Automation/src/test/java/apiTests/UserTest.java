package apiTests;

import framework.annotations.FrameworkAnnotation;
import framework.base.ApiBaseTest;
import framework.enums.CategoryTypes;
import framework.enums.ContentType;
import framework.enums.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import project.applicationApi.user.CreateUserApi;
import project.applicationApi.user.DeleteUserApi;
import project.applicationApi.user.GetUserApi;
import project.applicationApi.user.UpdateUserApi;
import project.pojos.request.CreateUserRequest;
import project.pojos.request.UpdateUserResquest;
import project.pojos.response.CreateUserResponse;
import project.pojos.response.GetUserResponse;
import project.pojos.response.UpdateUserResponse;

import static framework.utils.ApiVerificationManager.*;

/*
 * This Class covers all test for Store User
 * In this test it create User, Get User, Update User and Delete User
 */

public class UserTest extends ApiBaseTest {

    int userId = 10;
    String username = "Test_User";
    String firstName = "John";
    String lastName = "James";
    String email = "john@email.com";
    String password = "12345";
    String phone = "12345";
    int userStatus = 1;

    String userUpdatedName = "Test_User_Updated";
    String userNotFoundText = "User not found";

    @FrameworkAnnotation(category = {CategoryTypes.SMOKE})
    @Test(priority = 0)
    public void createUser() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setId(userId);
        createUserRequest.setUsername(username);
        createUserRequest.setFirstName(firstName);
        createUserRequest.setLastName(lastName);
        createUserRequest.setEmail(email);
        createUserRequest.setPassword(password);
        createUserRequest.setPhone(phone);
        createUserRequest.setUserStatus(userStatus);

        Response response = CreateUserApi.post(createUserRequest);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        CreateUserResponse responseData = response.as(CreateUserResponse.class);

        validateResponse("Id", responseData.getId(), userId);
        validateResponse("Username", responseData.getUsername(), username);
    }

    @FrameworkAnnotation(category = {CategoryTypes.SMOKE})
    @Test(priority = 1)
    public void getUserByUsername() {
        Response response = GetUserApi.getUserByUsername(username);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        GetUserResponse responseData = response.as(GetUserResponse.class);
        validateResponse("Id", responseData.getId(), userId);
        validateResponse("Username", responseData.getUsername(), username);
    }

    @FrameworkAnnotation(category={CategoryTypes.REGRESSION})
    @Test(priority = 2)
    public void updateUser() {
        UpdateUserResquest updateUserResquest = new UpdateUserResquest();
        updateUserResquest.setId(userId);
        updateUserResquest.setUsername(userUpdatedName);
        updateUserResquest.setFirstName(firstName);
        updateUserResquest.setLastName(lastName);
        updateUserResquest.setEmail(email);
        updateUserResquest.setPassword(password);
        updateUserResquest.setPhone(phone);
        updateUserResquest.setUserStatus(userStatus);

        Response response = UpdateUserApi.put(updateUserResquest,username);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        UpdateUserResponse responseData = response.as(UpdateUserResponse.class);

        validateResponse("Id",responseData.getId(), userId);
        validateResponse("Username",responseData.getUsername(), userUpdatedName);
    }


    @FrameworkAnnotation(category = {CategoryTypes.REGRESSION})
    @Test(priority = 3)
    public void deleteUser() {
        Response response = DeleteUserApi.deleteUserByUsername(userUpdatedName);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        Response getResponse = GetUserApi.getUserByUsername(userUpdatedName);
        validateContentType(getResponse.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(getResponse.statusCode(), StatusCode.CODE_404);
        validateResponse("Get Response Output ", getResponse.asString(), userNotFoundText);
    }
}