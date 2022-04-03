package project.applicationApi.user;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;

public class DeleteUserApi {

    public static Response deleteUserByUsername(String username){
        return RestResource.deleteWithoutResponseHasJson(Route.USER+"/"+username);
    }
}
