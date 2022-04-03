package project.applicationApi.pet;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;

public class GetPetApi {

    public static Response getPetById(int petId){
        return RestResource.get(Route.PET+"/"+ petId);
    }
}
