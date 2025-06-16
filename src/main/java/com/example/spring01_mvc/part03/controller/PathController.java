package com.example.spring01_mvc.part03.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

// 예시 URL: http://127.0.0.1:8090/pathcall/a001/5000
// pathcall 뒤에 오는 'a001'과 '5000' 값을 받아서 처리하는 컨트롤러

@Slf4j
@RestController  // REST 방식 컨트롤러, 반환값을 JSON으로 자동 변환해 클라이언트에 전달
public class PathController {

    // GET 방식 요청 중 /pathcall/{code}/{price} 경로와 매핑 http://localhost:8090/pathcall/a001/5000
    // {code}와 {price}는 URL 경로에서 동적으로 전달되는 값들임
    @GetMapping(value="/pathcall/{code}/{price}")
    public HashMap<String,Object> pathExecute(
            @PathVariable(name="code") String code,   // URL의 code 부분을 변수에 저장
            @PathVariable(name="price") int price) {  // URL의 price 부분을 변수에 저장

        // 전달받은 값 로그로 출력 (서버 콘솔에서 확인 가능)
        log.info("code:{}, price:{}", code, price);

        // 응답으로 보낼 데이터 저장용 맵 생성
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("code", code);    // code 값을 맵에 저장
        map.put("price", price);  // price 값을 맵에 저장

        // JSON 형태로 자동 변환되어 클라이언트에 반환됨
        return map;
    }
}

