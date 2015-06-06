package controllers;

import static play.libs.F.Function;
import play.libs.F.Callback;
import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

public class Login extends Controller{
	public Result login() {		
		JsonNode json = request().body().asJson();
		String username = json.get("username").textValue();
		String password = json.get("password").textValue();
		String input = "email=" + username + "&password=" + password;
		System.out.println(username);
		Promise<WSResponse> responsePromise = WS.url("http://172.20.200.60:8080/user/login").setContentType("application/x-www-form-urlencoded").post(input);
		System.out.println(responsePromise);
        WSResponse response = responsePromise.get(1000000);
        System.out.println(response);

		if("true".equals(response.getBody())){
            return ok("true");
        }
        return unauthorized();

	}
}
