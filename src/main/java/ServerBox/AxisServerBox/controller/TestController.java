package ServerBox.AxisServerBox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ServerBox.AxisServerBox.dto.MemberDTO;

@RestController   //제이슨이나 객체를 반환하는 컨트롤러, restcontroller는 @Controller + @ResponseBody
@RequestMapping(value = "/api/server")  //// 기본 URL 지정
public class TestController {
   private final Logger LOGGER=  LoggerFactory.getLogger(TestController.class);   //터미널에 로그를 찍기 위해 로그객체 생성

    @GetMapping(value = "/jong-ho")
    public String getTest(){
        LOGGER.info("getTest1 호출");          //스프링서버 터미널에 이 로그가 찍힘
        return "Hello Jong Ho from AxisServerBox";
    }

    @GetMapping(value = "/name")   //http://localhost:8080/api/server/name?name=홍길동    @RequestParam은 쿼리스트링으로 값을 받을 때 (?name=홍길동)
    public String getTest2(@RequestParam String name){
        LOGGER.info("getTest2 호출");
        return "Hello " +name+" from AxisServerBox";
    }

    @GetMapping(value = "/PathVariable/{name}")   //http://localhost:8080/api/server/PathVariable/마준서            @PathVariable은 URL 경로 자체에 포함된 값을 받을 때 사용합니다 (/홍길동)
    public String getTest3(@PathVariable String name){
        LOGGER.info("getTest3 호출");
        return "Hello " +name+" from AxisServerBox ";
    }

    //객체와 3가지 파라미터를 받을 때
    @PostMapping(value = "/member")   //http://localhost:8080/api/server/member?name=준형&email=test@example.com&group=admin
    public ResponseEntity<MemberDTO> getMember(
             @RequestBody MemberDTO memberDTO,
             @RequestParam String name,
             @RequestParam String email,
             @RequestParam String group){

        LOGGER.info("getMember 호출");
        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);  
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("axis-header") String header, @RequestBody MemberDTO memberDTO ){

        LOGGER.info("add-header 호출");
        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

}//**ResponseEntity Spring Framework에서 제공하는 클래스로, HTTP 응답(status, headers, body)을 아주 세밀하게 조작하고 싶을 때 사용하는 객체
