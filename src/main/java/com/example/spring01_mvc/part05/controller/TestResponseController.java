package com.example.spring01_mvc.part05.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController  // REST API 컨트롤러, JSON 혹은 직접 지정한 응답 반환
public class TestResponseController {

    // ResponseEntity 생성자 방식으로 응답 반환
    @GetMapping(value="/entity")
    public ResponseEntity<Object> helloCall() {
        log.info("ok");
        // 응답 바디에 "entity"라는 문자열을 담고, HTTP 상태코드 200(OK) 반환
        return new ResponseEntity<Object>("entity", HttpStatus.OK);
        // 참고: HttpStatus.BAD_GATEWAY는 502 에러 코드임
    }

    // ResponseEntity 빌더 패턴 사용 예
    @GetMapping(value="/builder")
    public ResponseEntity<Object> builderCall() {
        log.info("builder pattern");
        // ResponseEntity.ok()는 상태코드 200(OK)을 의미하며, body()로 응답 본문 지정 가능
        return ResponseEntity.ok("builder pattern");
    }
}

/*
 * [ResponseEntity 작성 방법]
 * 
 * 1. 생성자 패턴
 *    - new ResponseEntity<T>(HttpStatus.OK);
 *    - new ResponseEntity<T>(body, HttpStatus.OK);
 *    - new ResponseEntity<T>(headers, HttpStatus.OK);
 *    - new ResponseEntity<T>(body, headers, HttpStatus.OK);
 *
 * 2. 빌더 패턴 (가독성 좋고 유연한 방법)
 *    - ResponseEntity.ok()
 *        .headers(headers)
 *        .body(body);
 *    - ResponseEntity.ok().body(body);
 *    - ResponseEntity.ok(body);
 *    - ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build(); // 406 상태 코드, 바디 없이 반환
 *
 * ResponseEntity를 사용하면 HTTP 상태코드, 헤더, 응답 바디를 직접 제어 가능해
 * REST API에서 클라이언트에게 더 정확한 응답을 줄 수 있음
 */


