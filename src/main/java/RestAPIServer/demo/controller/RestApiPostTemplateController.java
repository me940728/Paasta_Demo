package RestAPIServer.demo.controller;

import RestAPIServer.demo.data.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 최별규
 * @version 1.1 데이터처리 REST Post Controller Template
 * => 정보 처리를 위한 레스트컨트롤러
 * => Post 방식은 리소스를 저장할 때 사용, 리소스 값을 HTTP body에 담아 서버에 전달함
 * => 그래서 Get 방식보다 URI가 간단함
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/post-api") /* 클래스 수준에서 @RequsetMapping 을 선언하면 내부 리소스 앞에 공통으로 값이 추가된다. */
public class RestApiPostTemplateController {

    /* SPRING 4.3버전 이전의 방식 */
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "RequestMapping Post";
    }
    /* localhost:8080/api/v1/post-api/member HTTP Body에 JSON으로 값을 보냄 정해진 규칙이 없는 데이터를 받을 때*/
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, String> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + ", " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    /* localhost:8080/api/v1/post-api/member2 HTTP Body에 JSON으로 값을 정해진 규칙이 있는 데이터를 받을 때*/
    /* UserInfoDto의 멤버 변수를 요청 메시지의 키와 매핑해 값을 가져옴 */
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody UserInfoDto userInfoDto){
        return userInfoDto.toString();
    }
}
