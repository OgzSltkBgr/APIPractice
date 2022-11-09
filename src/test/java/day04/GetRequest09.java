package day04;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPojos;
import pojos.CustomerPojos;
import pojos.UserPojos;
import utilities.GMIBankBaseURL;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends GMIBankBaseURL {
    /*
http://www.gmibank.com/api/tp-customers/110452
 */

    @Test
    public void test09() {
        // Set the URL
        spec01.pathParams("bir","tp-customers","iki",110452);

        // Set the Expected Data
        UserPojos user = new UserPojos(110016,"leopoldo.reinger","Jasmine","Stehr","marni.zboncak@yahoo.com",true,"en",null,null);

        CountryPojos country = new CountryPojos(3,"USA",null);

        CustomerPojos expectedData = new CustomerPojos(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs","Waltermouth"
                , "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user);

        Response response = given().spec(spec01).headers("Authorization","Bearer"+generateToken()).when().get("/{bir}/{iki}");

        CustomerPojos actualData= response.as(CustomerPojos.class);

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualData.getZipCode());
        assertEquals(expectedData.getAddress(),actualData.getAddress());
        assertEquals(expectedData.getCity(),actualData.getCity());
        assertEquals(expectedData.getSsn(),actualData.getSsn());
        assertEquals(expectedData.getCreateDate(),actualData.getCreateDate());
        assertEquals(expectedData.getZelleEnrolled(),actualData.getZelleEnrolled());
        assertEquals(expectedData.getCountry().getId(),actualData.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(),actualData.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(),actualData.getCountry().getStates());
        assertEquals(expectedData.getState(),actualData.getState());
        assertEquals(expectedData.getUser().getId(),actualData.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualData.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualData.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualData.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualData.getUser().getEmail());
        assertEquals(expectedData.getUser().getLangKey(),actualData.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualData.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualData.getUser().getResetDate());
    }
    /*
    /*
        {
        "id": 110452,
        "firstName": "Jasmine",
        "lastName": "Stehr",
        "middleInitial": "V",
        "email": "marni.zboncak@yahoo.com",
        "mobilePhoneNumber": "463-609-2097",
        "phoneNumber": "1-112-497-0270",
        "zipCode": "16525",
        "address": "14387 Al Ridge5343 Bert Burgs",
        "city": "Waltermouth",
        "ssn": "761-59-2911",
        "createDate": "2021-11-28T21:00:00Z",
        "zelleEnrolled": false,
        "country": {
            "id": 3,
            "name": "USA",
            "states": null
        },
        "state": "California",
        "user": {
            "id": 110016,
            "login": "leopoldo.reinger",
            "firstName": "Jasmine",
            "lastName": "Stehr",
            "email": "marni.zboncak@yahoo.com",
            "activated": true,
            "langKey": "en",
            "imageUrl": null,
            "resetDate": null
        },
        "accounts": []
    }
         */

}
