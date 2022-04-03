package framework.api;

import framework.reports.ExtentLogger;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.PrintStream;
import java.io.StringWriter;

import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(Object request, String path) {
        StringWriter writerRequest;
        PrintStream captor;
        writerRequest = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(SpecBuilder.postRequestSpec())
                .body(request)
                .filter(new RequestLoggingFilter(captor))
                .when().post(path)
                .then().spec(SpecBuilder.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static Response put(Object request, String path) {
        StringWriter writerRequest;
        PrintStream captor;
        writerRequest = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(SpecBuilder.postRequestSpec())
                .body(request)
                .filter(new RequestLoggingFilter(captor))
                .when().put(path)
                .then().spec(SpecBuilder.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static Response delete(String path) {
        StringWriter writerRequest;
        PrintStream captor;
        writerRequest = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(SpecBuilder.deleteByIdRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .when().delete(path)
                .then().spec(SpecBuilder.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    public static Response deleteWithoutResponseHasJson(String path) {
        StringWriter writerRequest;
        PrintStream captor;
        writerRequest = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(SpecBuilder.deleteByIdRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .when().delete(path)
                .then().spec(SpecBuilder.getResponseSpecWithoutJson())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }


    public static Response get(String path) {
        StringWriter writerRequest;
        PrintStream captor;
        writerRequest = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writerRequest), true);

        Response response = given(SpecBuilder.getRequestSpec())
                .filter(new RequestLoggingFilter(captor))
                .when().get(path)
                .then().spec(SpecBuilder.getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport(writerRequest, response);

        return response;
    }

    private static void printDetailsInExtentReport(StringWriter writer, Response response) {
        ExtentLogger.info("<details><summary><i><font> Request details: </font></i>" + "</summary>"
                + "<pre>" + writer.toString() + "</pre>" + "</details> \n");
        ExtentLogger.info("<details><summary><i><font> Response details: </font></i>" + "</summary>"
                + "<pre>" + response.asString() + "</pre>" + "</details> \n");
    }
}
