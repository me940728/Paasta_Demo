package RestAPIServer.demo.controller;

import RestAPIServer.demo.data.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 최별규
 * @version 1.1 데이터처리 REST Get Controller Template
 * => 정보 처리를 위한 레스트컨트롤러
 * => Get 방식은 URL의 경로나 파라미터에 변수를 넣어 요청을 보냄
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/get-api") /* 클래스 수준에서 @RequsetMapping 을 선언하면 내부 리소스 앞에 공통으로 값이 추가된다. */
public class RestApiGetTemplateController {

    /* SPRING 4.3버전 이전의 방식 */
    @RequestMapping(value = "/req-hello", method = RequestMethod.GET)
    public String getHello(){
        return "RequestMapping Hello";
    }
    /* Spring 4.3 버전 이상 Get 방식 */
    @GetMapping("/hello")
    public String getHello_GetMapping(){
        return "GetMapping Hello";
    }
    /* Spring 4.3 버전 이상 Get 방식, @PathVariable */
    @GetMapping("/variable1/{variable}") // => {} 안에 값이 매핑되고 get 방식일 때 많이 사용
    public String getHello_GetMapping_PathVar(@PathVariable String variable){
                            // => {String} 이름과 @PathVariable 의 변수 이름이 같아야 함
        String val = variable;
        return val;
    }
    /* Spring 4.3 버전 이상 Get 방식2, @PathVariable */
    @GetMapping("/variable2/{variable}") // => {} 안에 값이 매핑되고 get 방식일 때 많이 사용
    public String getHello_GetMapping_PathVar2(@PathVariable("variable") String var){
        // => {String} 이름과 @PathVariable 의 변수 이름이 같아야 함
        return var;
    }
    /* Spring 4.3 버전 이상 Get 방식1, @RequestParam 쿼리스트링의 매개변수의 갯수를 알 때*/
    /* localhost:8080/api/v1/test/get-api/request1?id=val1&pwd=val2 요청  */
    @GetMapping("/request1")
    public String getHello_GetMapping_ReqParam(
            @RequestParam  String id,
            @RequestParam String pwd) {
        return id + pwd + "입니다.";
    }
    /* Spring 4.3 버전 이상 Get 방식1, @RequestParam 쿼리스트링의 매개변수의 갯수를 모를 때*/
    /* 회원 가입 시 사용자 취및 등 선택 항목을 제외하고 받을 때 사용함 */
    /* localhost:8080/api/v1/test/get-api/request2?key1=val1&key2=val2&key3=val3 요청  */
    @GetMapping("/request2")
    public String getHello_GetMapping_ReqParam2(Map<String, String> pMap){
        StringBuilder sb = new StringBuilder();
        pMap.entrySet().forEach(map -> {
            sb.append(map.getKey() + ", " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    /* Spring 4.3 버전 이상 Get 방식1, Dto를 사용한 가독성 높히기 */
    /* localhost:8080/api/v1/test/get-api/dto?name=val1&email=val2*/
    @GetMapping("/dto")
    public String getHello_GetMapping_Dto(UserInfoDto userDto){
        return userDto.toString();
    }

}
