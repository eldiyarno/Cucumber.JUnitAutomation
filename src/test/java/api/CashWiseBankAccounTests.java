package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.xml.StreamingDOMBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;
import utilities.CashwiseAuthorization;
import utilities.Config;

import java.util.List;

public class CashWiseBankAccounTests {


    @Test
    public void getAllBankAccount(){
        String token = CashwiseAuthorization.getToken();
        Response response = RestAssured.given().auth().oauth2(token).get(Config.getValue("apiCashWiseURL")+"/api/myaccount/bankaccount");
        System.out.println(response.statusCode());
        response.prettyPrint();
        int size = response.jsonPath().getInt("$.size()");


        for (int i = 0; i<size; i++ ){
            String accountType = response.jsonPath().getString("["+i+"].type_of_pay");
            String bankAccountType = response.jsonPath().getString("["+i+"].bank_account_name");
           String balance =response.jsonPath().getString("["+i+"].balance");
            Assert.assertFalse("Bank account name is empty",bankAccountType.trim().isEmpty());
            Assert.assertFalse("Bank type is empty",accountType.trim().isEmpty());
            Assert.assertFalse("balance is empty",balance.trim().isEmpty());
        }

    }

    @Test
    public void getAllAccounts() throws JsonProcessingException {
        String token  = CashwiseAuthorization.getToken();
        String url = Config.getValue("apiCashWiseURL")+"/api/myaccount/bankaccount/";
        Response response = RestAssured.given().auth().oauth2(token).get(url);


        ObjectMapper mapper = new ObjectMapper();
        CustomResponse[] customResponse = mapper.readValue(response.asString(), CustomResponse[].class);
        System.out.println(customResponse.length);


        for (int i = 0; i<customResponse.length; i++){

            if (customResponse[i].getBalance()<1000){
                int id = customResponse[i].getId();
                Response response1 = RestAssured.given().auth().oauth2(token).delete(url+id);
                System.out.println(response1.statusCode());
                response1.prettyPrint();
            }
        }

    }


}
