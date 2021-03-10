package N26Task.SmokePetstore;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class smokeTestSuite {
	
	
	
	Random rand = new Random(); 
	public int id = rand.nextInt(1000000); 
	
	@Test(priority = 0)
	
	public void AddPet()
	{
		RestAssured.baseURI = "http://localhost:8080/api/v3";
		given().log().all().header("Content-Type", "application/json")
		.body(Payloads.CreateBody(id))
		.when().post("pet").then().log().all().assertThat().statusCode(200);
	}
	
	@Test(priority = 1,dependsOnMethods ="AddPet")
	public void FindPet() {

		given().log().all().with().pathParam("petId", id).when().get("pet/{petId}").then().log().all()
				.statusCode(200);
	}
	
	
	@Test(priority = 2,dependsOnMethods ="FindPet")
	public void UpdatePet() {
		given().log().all().header("Content-Type", "application/json")
				.body(Payloads.UpdateBody(id))
				.when().put("pet").then().log().all().assertThat().statusCode(200);
	}
	
	@Test(priority = 3,dependsOnMethods ="UpdatePet")

	public void VerifyPetUpdate() {
		String response = given().log().all().with().pathParam("petId", id).when().get("pet/{petId}").then().log()
				.all().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String UpdatedStatus = js.getString("status");
		// System.out.println(UpdatedStatus);
		String expStatus = "not available";

		assertEquals(expStatus, UpdatedStatus);
		// assert.assertEquals("not available", UpdatedStatus);

	}

	@Test(priority = 4, dependsOnMethods ="AddPet")
	public void DeletePet() {
		given().log().all().when().delete("pet/" + id + "").then().log().all().statusCode(200);
	}

	@Test(priority = 5, dependsOnMethods ="DeletePet")
	public void VerifyPetDelete() {
		String Response2 = given().log().all().with().pathParam("petId", id).when().get("pet/{petId}").then().log()
				.all().extract().response().asString();
		
		//System.out.println(Response2);
		//JsonPath js1 = new JsonPath(Response2);
		//String ActMessage = js1.getString("message");
		String ExpMessage = "Pet not found";
		
		//assertEquals(ActMessage, ExpMessage);
		assertEquals(Response2, ExpMessage);
		
	}
	

}
