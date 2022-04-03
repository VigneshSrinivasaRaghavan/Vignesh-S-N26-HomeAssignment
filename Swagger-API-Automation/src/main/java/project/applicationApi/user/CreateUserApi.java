package project.applicationApi.user;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;
import project.pojos.request.CreateUserRequest;

public class CreateUserApi {

    public static Response post(CreateUserRequest createUser){
        return RestResource.post(createUser, Route.USER);
    }
}
