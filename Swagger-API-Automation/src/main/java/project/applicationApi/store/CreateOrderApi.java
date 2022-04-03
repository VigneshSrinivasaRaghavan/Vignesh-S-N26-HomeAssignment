package project.applicationApi.store;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;
import project.pojos.request.CreateOrderRequest;

public class CreateOrderApi {

    public static Response post(CreateOrderRequest createOrder){
        return RestResource.post(createOrder, Route.STORE+Route.ORDER);
    }
}
