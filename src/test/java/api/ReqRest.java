package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.CashwiseAuthorization;

public class ReqRest {
    public static void main(String[] args) {
       Response response = RestAssured.get("https://reqres.in/api/users/7");
        System.out.println(response.statusCode());
        response.prettyPrint();
        String email = response.jsonPath().get("data.email").toString();
        String firstName =response.jsonPath().get("data.first_name").toString();
        String lastName =response.jsonPath().get("data.last_name").toString();
        String avatar =response.jsonPath().get("data.avatar").toString();
        Assert.assertFalse(email.isEmpty());
        Assert.assertFalse(firstName.isEmpty());
        Assert.assertFalse(lastName.isEmpty());
        Assert.assertFalse(avatar.isEmpty());

        Assert.assertTrue(email.endsWith("reqres.in"));
        Assert.assertTrue(avatar.endsWith(".png")||avatar.endsWith(".jpg"));
        System.out.println(CashwiseAuthorization.getToken());

    }
}
