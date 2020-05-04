package deckofcards.cucumber.apicommunicator;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@Component
public class ApiCommunicator {

    public ValidatableResponse postResponse(String endPoint, Map<String, Object> payload) {
        return run(Method.POST, endPoint, given().body(payload).contentType(ContentType.JSON).when());
    }
    
    public ValidatableResponse postResponse(String endPoint) {
        return run(Method.POST, endPoint, given().when());
    }

    public ValidatableResponse putRequest(String endPoint,Map<String, Object> payload) {
        return run(Method.PUT, endPoint, given().body(payload).contentType(ContentType.JSON).when());
    }

    public ValidatableResponse getRequest(String endPoint) {
        return run(Method.GET, endPoint, given().contentType(ContentType.JSON).when());
    }


    public ValidatableResponse deleteRequest(String endPoint) {
        return run(Method.DELETE, endPoint, given().contentType(ContentType.JSON).when());
    }
    
    public ValidatableResponse run(Method method, String endpoint, RequestSpecification requestSpecification) {
        ValidatableResponse validatableResponse = null;
        Response response = getResponse(method, endpoint, requestSpecification);
        validatableResponse = response.then();
        return validatableResponse;
    }
    
    private Response getResponse(Method method, String endpoint, RequestSpecification requestSpecification) {
        requestSpecification = settingTimeout(requestSpecification);
        Response response = null;
        switch (method) {
            case GET: {
                response = requestSpecification.get(endpoint);
                break;
            }
            case PUT: {
                response = requestSpecification.put(endpoint);
                break;
            }
            case POST: {
                response = requestSpecification.post(endpoint);
                break;
            }
            case DELETE: {
                response = requestSpecification.delete(endpoint);
                break;
            }
            case HEAD: {
                response = requestSpecification.head(endpoint);
                break;
            }
            case TRACE: {
                break;
            }
            case OPTIONS: {
                response = requestSpecification.options(endpoint);
                break;
            }
            case PATCH: {
                response = requestSpecification.patch(endpoint);
                break;
            }
        }

        return response;
    }

    private RequestSpecification settingTimeout(RequestSpecification requestSpecification) {
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig());
        return requestSpecification.config(config);
    }


}
