package project.applicationApi.pet;

import framework.api.RestResource;
import io.restassured.response.Response;
import project.pojos.request.CreatePetRequest;

public class CreatePetApi {

    public static Response post(CreatePetRequest createPetRequest){
        return RestResource.post(createPetRequest,"/pet");
    }
}
