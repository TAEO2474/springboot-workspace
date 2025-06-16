package com.example.spring01_mvc.part03.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
// http:127.0.0.1:8090/pathcall/a001/5000
@Slf4j
@RestController
public class PathController {
	@GetMapping(value="/pathcall/{code}/{price}")
	public HashMap<String,Object> pathExecute(@PathVariable(name="code") String code,
											@PathVariable(name="price") int price){
													
		log.info("code:{},price{}",code,price);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("code", code);	
		map.put("price", price);
		
		return map;
	}
}
