package com.example.spring01_mvc.part02.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01_mvc.part02.dto.MemDTO;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController     //-> @Controller + @ResponseBody 기능 합친 어노테이션, 반환값을 JSON으로 바로 보내줌
public class HelloPostController {
	
	// 클라이언트가 JSON 형태로 보내는 데이터를 MemDTO 객체로 변환해서 받음
    // 예시 JSON: {"num":1, "name":"홍길동","age":30, "loc":"서울"}
	@PostMapping(value="/hellomodel")
	public MemDTO postExecute(@RequestBody MemDTO dto) {
		log.info("dto{}", dto);// DTO 객체 내용을 로그로 출력 (서버 콘솔 확인용)
		return dto; // 받은 DTO를 그대로 JSON 형식으로 응답(body)에 담아 반환

		
	}

}

// <이번 수업 주제와 핵심 내용>
//REST API 방식 POST 요청 처리
//클라이언트가 JSON 데이터를 서버로 보내면, 서버가 이를 Java 객체로 받고 다시 JSON으로 응답하는 흐름 이해하기
//DTO(Data Transfer Object)의 역할
//JSON ↔ Java 객체 간 변환 매개체로 사용
//Spring Boot에서 자동 JSON 변환
//@RestController와 @RequestBody가 핵심 역할을 함