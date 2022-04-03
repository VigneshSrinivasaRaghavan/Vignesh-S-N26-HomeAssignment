package project.applicationApi.user;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;

public class GetUserApi {

    public static Response getUserByUsername(String username){
        return RestResource.get(Route.USER+"/"+username);
    }
}
