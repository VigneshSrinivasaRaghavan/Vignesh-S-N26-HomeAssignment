package project.applicationApi.store;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;

public class GetOrderApi {

    public static Response getOrderById(int orderId){
        return RestResource.get(Route.STORE+Route.ORDER+"/"+orderId);
    }
}
