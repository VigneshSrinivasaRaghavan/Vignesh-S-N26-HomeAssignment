package project.applicationApi.pet;

import framework.api.RestResource;
import io.restassured.response.Response;
import project.pojos.request.CreatePetRequest;

public class UpdatePetApi {

    public static Response put(CreatePetRequest createPetRequest){
        return RestResource.put(createPetRequest,"/pet");
    }
}
