package RestAPIServer.demo.controller;

import RestAPIServer.demo.data.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 최별규
 * @version 1.1 데이터처리 REST Put Controller Template
 * => 정보 처리를 위한 레스트컨트롤러
 * => Put 방식은 리소스를 수정(업데이트)할 때 사용, 리소스 값을 HTTP body에 담아 서버에 전달함
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/put-api") /* 클래스 수준에서 @RequsetMapping 을 선언하면 내부 리소스 앞에 공통으로 값이 추가된다. */
public class RestApiPutTemplateController {

    /* localhost:8080/api/v1/put-api/member HTTP Body에 JSON으로 값을 보냄 정해진 규칙이 없는 데이터를 받을 때*/
    @PostMapping(value = "/member") /* JSON으로 받기 떄문에 */
    public String putMember(@RequestBody Map<String, String> putData){
        log.info("=============================START");
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + ": " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    /* localhost:8080/api/v1/put-api/member2 HTTP Body에 JSON으로 값을 정해진 규칙이 있는 데이터를 받을 때*/
    /* UserInfoDto의 멤버 변수를 요청 메시지의 키와 매핑해 값을 가져옴 */
    @PostMapping(value = "/member2")
    public String putMemberDto(@RequestBody UserInfoDto userInfoDto){

        return userInfoDto.toString(); /* => toString 을 하지 않으면 객체를 반환한다.*/
    }

    /* < HttpEntity > 객체 사용한 수정 메서드
    * 해당 객체는 헤더와 바디로 구성된 HTTP 요청과 응답을 구성하는 역할을 수행한다.
    * RequestEntity 와 ResponseEntity 는 HttpEntity 를 상속받아 구현한 클래스 이다.
    * 수정 뿐 아니라 Get Post Delete Put 다 사용 가능하다.
    * */
    // => localhost:8080/api/v1/put-api/member3
    @PutMapping("/member3")
    public ResponseEntity<UserInfoDto> putMemberDto2(@RequestBody UserInfoDto userInfoDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userInfoDto);
    }

}
