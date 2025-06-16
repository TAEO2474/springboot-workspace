package com.example.spring01_mvc.part01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.spring01_mvc.part01.dto.HelloDTO;

//http://127.0.0.1:8090/hello
//http://localhost:8090/hello
@Controller
public class HelloController {

	@GetMapping(value="/hello") //@GetMapping 어노테이션 : HTTP GET 요청을 특정 메서드에 매핑(연결)
	@ResponseBody  //@ResponseBody 어노테이션:메서드의 반환 값을 JSON, XML 등으로 변환해서 HTTP 응답 본문에 직접 출력
	public String hell0() {
		return "Hello Spring Boots!!";
	}
	
	//http://127.0.0.1:8090/member
	@GetMapping(value="/member")
	@ResponseBody
	public String member() {
		HelloDTO dto = new HelloDTO();
		dto.setName("홍길동");
		dto.setAge(30);
		return dto.toString(); 
		//@ResponseBody나 @RestController 를 사용하지 않아서, 
		// 그 단순하게 그 값만 문자열로 보내주기 위해 투스트링을 호출
		
	}
	
}
