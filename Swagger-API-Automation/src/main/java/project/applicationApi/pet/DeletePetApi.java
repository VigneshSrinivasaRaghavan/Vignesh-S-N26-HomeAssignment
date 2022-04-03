package project.applicationApi.pet;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;
import project.pojos.request.CreatePetRequest;

public class DeletePetApi {

    public static Response deletePetById(int petId){
        return RestResource.delete(Route.PET+"/"+petId);
    }
}
