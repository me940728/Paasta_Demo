package RestAPIServer.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author 최별규
 * @version 1.1 데이터처리 REST Delete Controller Template
 * => 정보 처리를 위한 레스트컨트롤러
 * => Delete 방식은 리소스를 삭제할 때 사용, 리소스 값을 HTTP body에 담아 서버에 전달함
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/delete-api") /* 클래스 수준에서 @RequsetMapping 을 선언하면 내부 리소스 앞에 공통으로 값이 추가된다. */
public class RestApiDeleteTemplateController {

    /* @PathVariable 사용 => localhost:8080/api/v1/delete-api/{String Value} */
    @DeleteMapping(value = "/{variable}")
    public String deleteVariable(@PathVariable String variable){
        String var = variable;
        return var;
    }
    /* @RequestParam 사용 => localhost:8080/api/v1/delete-api/request */
    @DeleteMapping(value = "/request")
    public String deleteVariable2(@RequestParam String name){
        return "name : " + name;
    }

}
