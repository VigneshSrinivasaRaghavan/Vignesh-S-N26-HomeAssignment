package framework.api;

import framework.enums.ConfigProperties;
import framework.utils.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public static RequestSpecification postRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(PropertyUtils.getValue(ConfigProperties.BASE_URL))
                .setBasePath(Route.API_VERSION)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(PropertyUtils.getValue(ConfigProperties.BASE_URL))
                .setBasePath(Route.API_VERSION)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification deleteByIdRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(PropertyUtils.getValue(ConfigProperties.BASE_URL))
                .setBasePath(Route.API_VERSION)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpecWithoutJson(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
