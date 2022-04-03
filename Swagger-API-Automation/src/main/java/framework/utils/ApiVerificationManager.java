package framework.utils;

import framework.enums.ContentType;
import framework.enums.StatusCode;
import framework.reports.ExtentLogger;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ApiVerificationManager {

    public static void validateResponse(String fieldName, Object actual, Object expected) {
        String message = "Assertion for "+fieldName+" Field";

        try {
            assertThat(actual, equalTo(expected));
            ExtentLogger.pass(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
        } catch (AssertionError assertionError) {
            ExtentLogger.fail(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
            Assert.fail("Actual value is "+actual+ " But Expected Value is : "+expected);
        }
    }

    public static void validateStatusCode(int actual, StatusCode statusCode) {
        String message = "Assertion for Status Code";

        try {
            assertThat(actual, equalTo(statusCode.code));
            ExtentLogger.pass(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + statusCode.code);
        } catch (AssertionError assertionError) {
            ExtentLogger.fail(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + statusCode.code);
            Assert.fail("Actual value is "+actual+ " But Expected Value is : "+statusCode.code);
        }
    }

    public static void validateContentType(String actual, ContentType contentType) {
        String message = "Assertion for Content Type";

        try {
            assertThat(actual, equalTo(contentType.type));
            ExtentLogger.pass(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + contentType.type);
        } catch (AssertionError assertionError) {
            ExtentLogger.fail(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + contentType.type);
            Assert.fail("Actual value is "+actual+ " But Expected Value is : "+contentType.type);
        }
    }

}
