package apiTests;

import framework.annotations.FrameworkAnnotation;
import framework.base.ApiBaseTest;
import framework.enums.CategoryTypes;
import framework.enums.ContentType;
import framework.enums.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import project.applicationApi.pet.GetPetApi;
import project.applicationApi.store.CreateOrderApi;
import project.applicationApi.store.DeleteOrderApi;
import project.applicationApi.store.GetOrderApi;
import project.pojos.request.CreateOrderRequest;
import project.pojos.response.CreateOrderResponse;
import project.pojos.response.GetOrderByIdResponse;

import static framework.utils.ApiVerificationManager.*;

/*
 * This Class covers all test for Store Order
 * In this test it create Order, Get Order, Update Order and Delete Order
 */

public class StoreTest extends ApiBaseTest {
    int orderId = 10;
    int petId = 198772;
    int quantity = 10;
    String statusValue = "approved";
    boolean completeValue = true;

    @FrameworkAnnotation(category={CategoryTypes.SMOKE})
    @Test(priority = 0)
    public void createOrder() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setId(orderId);
        createOrderRequest.setPetId(petId);
        createOrderRequest.setQuantity(quantity);
        createOrderRequest.setStatus(statusValue);
        createOrderRequest.setComplete(completeValue);

        Response response = CreateOrderApi.post(createOrderRequest);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        CreateOrderResponse responseData = response.as(CreateOrderResponse.class);

        validateResponse("Id",responseData.getId(), orderId);
        validateResponse("Pet Id",responseData.getPetId(), petId);
        validateResponse("Status",responseData.getStatus(), statusValue);
    }

    @FrameworkAnnotation(category={CategoryTypes.SMOKE})
    @Test(priority = 1)
    public void getOrderByID() {
        Response response = GetOrderApi.getOrderById(orderId);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        GetOrderByIdResponse responseData = response.as(GetOrderByIdResponse.class);
        validateResponse("Id",responseData.getId(), orderId);
        validateResponse("Pet Id",responseData.getPetId(), petId);
        validateResponse("Status",responseData.getStatus(), statusValue);
    }
    

    @FrameworkAnnotation(category={CategoryTypes.REGRESSION})
    @Test(priority = 2)
    public void deleteOrder() {
        String orderNotFoundText = "Order not found";

        Response response = DeleteOrderApi.deleteOrderById(orderId);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        Response getResponse = GetOrderApi.getOrderById(orderId);
        validateContentType(getResponse.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(getResponse.statusCode(), StatusCode.CODE_404);
        validateResponse("Get Response Output ",getResponse.asString(),orderNotFoundText);
    }
}