package apiTests;

import com.sun.tools.javac.util.List;
import framework.annotations.FrameworkAnnotation;
import framework.base.ApiBaseTest;
import framework.enums.CategoryTypes;
import framework.enums.ContentType;
import framework.enums.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import project.applicationApi.pet.CreatePetApi;
import project.applicationApi.pet.DeletePetApi;
import project.applicationApi.pet.GetPetApi;
import project.applicationApi.pet.UpdatePetApi;
import project.pojos.request.CategoryRequest;
import project.pojos.request.CreatePetRequest;
import project.pojos.request.TagRequest;
import project.pojos.response.GetPetByIdResponse;

import static framework.utils.ApiVerificationManager.*;

/*
 * This Class covers all test for Pet
 * In this test it create Pet, Get Pet Details, Update Pet Details and Delete Pet Details
 */

public class PetTest extends ApiBaseTest {
    int petId = 13;
    @FrameworkAnnotation(category={CategoryTypes.SMOKE})
    @Test(priority = 0)
    public void createPet() {
        String petName = "Test Dog";
        String statusValue = "available";
        int categoryId = 1;
        String categoryName = "Dogs";
        int tagId = 0;
        String tagName = "New Dog";
        String photoUrlName = "String";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(petName);

        CategoryRequest category = new CategoryRequest(categoryId, categoryName);
        createPetRequest.setCategory(category);

        TagRequest tag = new TagRequest(tagId,tagName);
        createPetRequest.setTags(List.of(tag));

        createPetRequest.setPhotoUrls(List.of(photoUrlName));
        createPetRequest.setStatus(statusValue);

        Response response = CreatePetApi.post(createPetRequest);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        GetPetByIdResponse responseData = response.as(GetPetByIdResponse.class);

        validateResponse("Id",responseData.getId(), petId);
        validateResponse("Category",responseData.getCategory().getName(), categoryName);
        validateResponse("Status",responseData.getStatus(), statusValue);
    }

    @FrameworkAnnotation(category={CategoryTypes.SMOKE})
    @Test(priority = 1)
    public void getPetByID() {
        Response response = GetPetApi.getPetById(petId);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        GetPetByIdResponse responseData = response.as(GetPetByIdResponse.class);
        validateResponse("Id",responseData.getId(), petId);
    }

    @FrameworkAnnotation(category={CategoryTypes.REGRESSION})
    @Test(priority = 2)
    public void updatePetDetails() {
        String dogUpdatedName = "Test Dog Updated";
        String statusValue = "available";
        int categoryId = 1;
        String categoryName = "Dogs";
        int tagId = 0;
        String tagName = "New Dog";
        String photoUrlName = "String";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(dogUpdatedName);

        CategoryRequest category = new CategoryRequest(categoryId,categoryName);
        createPetRequest.setCategory(category);

        TagRequest tag = new TagRequest(tagId,tagName);
        createPetRequest.setTags(List.of(tag));

        createPetRequest.setPhotoUrls(List.of(photoUrlName));
        createPetRequest.setStatus(statusValue);

        Response response = UpdatePetApi.put(createPetRequest);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);

        GetPetByIdResponse responseData = response.as(GetPetByIdResponse.class);

        validateResponse("Id",responseData.getId(), petId);
        validateResponse("Category",responseData.getCategory().getName(), categoryName);
        validateResponse("Status",responseData.getStatus(), statusValue);


        Response getResponse = GetPetApi.getPetById(petId);
        validateContentType(getResponse.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(getResponse.statusCode(), StatusCode.CODE_200);

        GetPetByIdResponse getResponseData = getResponse.as(GetPetByIdResponse.class);
        validateResponse("Id",getResponseData.getId(), petId);
        validateResponse("Name",getResponseData.getName(), dogUpdatedName);
    }

    @FrameworkAnnotation(category={CategoryTypes.REGRESSION})
    @Test(priority = 3)
    public void deletePet() {
        String petDeletedText = "Pet deleted";
        String petNotFoundText = "Pet not found";

        Response response = DeletePetApi.deletePetById(petId);
        validateContentType(response.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(response.statusCode(), StatusCode.CODE_200);
        validateResponse("Delete Response Output",response.asString(),petDeletedText);

        Response getResponse = GetPetApi.getPetById(petId);
        validateContentType(getResponse.contentType(), ContentType.APPLICATION_JSON);
        validateStatusCode(getResponse.statusCode(), StatusCode.CODE_404);
        validateResponse("Get Response Output ",getResponse.asString(),petNotFoundText);
    }
}