package com.example.spring01_mvc.part05.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestResponseController {
	@GetMapping(value="/entity")
	public ResponseEntity<Object> helloCall() {
		log.info("ok");
		return new ResponseEntity<Object> ("entity", HttpStatus.OK); // ok =200 ,BAD_GATEWAY =502
	}

	@GetMapping(value="/builder")
	public ResponseEntity<Object> builderCall() {
		log.info("builder pattern");
		//return ResponseEntity.ok().body("builder pattern");
		return ResponseEntity.ok("builder pattern");
	}
}

/*
 * [ResponseEntity 작성방법]
 * 1. 생성자 패턴
 *  return new ResponseEntity<List<TodoDTO>>(HttpStatus.OK);
    return new ResponseEntity<List<TodoDTO>>(body, HttpStatus.OK);
    return new ResponseEntity<List<TodoDTO>>(headers, HttpStatus.OK);
    return new ResponseEntity<List<TodoDTO>>(body,headers, HttpStatus.OK);
 * 2. 빌더 패턴
 *  return ResponseEntity.ok()
	.headers(headers)
	.body(body);
	
	return ResponseEntity.ok().body(body);	
	return ResponseEntity.ok(body);	
	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
 */


