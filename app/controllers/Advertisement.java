package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import play.libs.F;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

public class Advertisement extends Controller{
	public Result getAds(int id){
//		HashMap<String, String> prod1= new LinkedHashMap<String, String>();
//		prod1.put("title", "fridge");
//		prod1.put("description", "this is a fridge");
//		prod1.put("value","5000" );
//		HashMap<String, String> prod2= new LinkedHashMap<String, String>();
//		prod2.put("title", "car");
//		prod2.put("description", "this is a car");
//		prod2.put("value","500000" );
//		List<Object> finalRes= new ArrayList<Object>();
//		finalRes.add(prod1);
//		finalRes.add(prod2);
        F.Promise<WSResponse> responsePromise = WS.url("http://172.20.200.60:8080/category/"+id+"/item").get();
        System.out.println(responsePromise);
        WSResponse response = responsePromise.get(1000000);
		return ok(response.getBody());
	}
}
