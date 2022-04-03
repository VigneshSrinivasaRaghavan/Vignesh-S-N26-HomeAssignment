package apiTests;

import framework.annotations.FrameworkAnnotation;
import framework.base.ApiBaseTest;
import framework.enums.CategoryTypes;
import framework.enums.ContentType;
import framework.enums.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import project.applicationApi.store.CreateOrderApi;
import project.applicationApi.store.GetOrderApi;
import project.pojos.request.CreateOrderRequest;
import project.pojos.response.GetOrderByIdResponse;

import static framework.utils.ApiVerificationManager.*;

/*
 * This test covers the negative scenarios
 * This test is to check if Report displays failed test along with proper Stack trace
 */

public class NegativeTest extends ApiBaseTest {
    int orderId = 10;
    int petId = 198772;
    int quantity = 10;
    String statusValue = "approved";
    boolean completeValue = true;

    @FrameworkAnnotation(category = {CategoryTypes.SMOKE})
    @Test(priority = 0)
    public void createOrderNegativeTest() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setId(orderId);
        createOrderRequest.setPetId(petId);
        createOrderRequest.setQuantity(quantity);
        createOrderRequest.setStatus(statusValue);
        createOrderRequest.setComplete(completeValue);

        Response response = CreateOrderApi.post(createOrderRequest);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_201);
    }
}