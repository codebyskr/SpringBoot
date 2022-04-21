package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	
	@GetMapping("/show")
	public ResponseEntity<List<ResponseData>> showData(){
		
		JSONArray jsonData = new JSONArray("[\r\n" + "		                                	{\r\n"
				+ "		                                		\"itemName\":\"Apple\",\r\n"
				+ "		                                		\"price\":200\r\n"
				+ "		                                	},\r\n" + "		                                	{\r\n"
				+ "		                                		\"itemName\":\"Mango\",\r\n"
				+ "		                                		\"price\":99\r\n"
				+ "		                                	},\r\n" + "		                                	{\r\n"
				+ "		                                		\"itemName\":\"PineApple\",\r\n"
				+ "		                                		\"price\":100\r\n"
				+ "		                                	}\r\n" + "		                                ]");
		
		List<JSONObject> joList = new ArrayList<>();
		
		jsonData.forEach(object -> {
			joList.add((JSONObject) object);
		});
		
		List<ResponseData> list = new ArrayList<ResponseData>();
		
		joList.stream()
			.filter(jo ->jo.getInt("price") >= 10)
			.forEach(jo -> { 
				list.add(new ResponseData(jo.getString("itemName"),jo.getInt("price")));
				});
		
		Comparator<ResponseData> comp = Comparator.comparing(ResponseData::getPrice).reversed();
		//Comparator<ResponseData> revComp = comp.reversed();
		
		Collections.sort(list,comp);
		return ResponseEntity.ok(list);
	}
}
