package project.applicationApi.store;

import framework.api.RestResource;
import framework.api.Route;
import io.restassured.response.Response;

public class DeleteOrderApi {

    public static Response deleteOrderById(int orderId){
        return RestResource.deleteWithoutResponseHasJson(Route.STORE+ Route.ORDER+"/"+orderId);
    }
}
