package project.applicationApi.user;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;
import project.pojos.request.UpdateUserResquest;

public class UpdateUserApi {

    public static Response put(UpdateUserResquest updateUserResquest,String userName){
        return RestResource.put(updateUserResquest, Route.USER+"/"+userName);
    }
}
