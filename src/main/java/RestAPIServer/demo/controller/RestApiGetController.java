package RestAPIServer.demo.controller;

import RestAPIServer.demo.data.dto.UserInfoDto;
import RestAPIServer.demo.service.UserLoginService;
import RestAPIServer.demo.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 최별규
 * @version 1.1 비동기 처리 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/user/info")
public class RestApiGetController {
    private final UserLoginService userLoginService;
    @Autowired
    RestApiGetController(UserLoginService userLoginService){ this.userLoginService = userLoginService; }
    /**
     * @author 최별규
     * @version 1.1 이메일(PK)로 중복 가입 확인 비동기 메서드
     * @param UserInfoDto pDto // => error 해결하기
     * @return int
     * @date 2022.09.03
     */
    @ResponseBody
    @GetMapping("/email")
    public int userEmailOverlapCheck(@RequestParam String email){
        UserInfoDto pDto = new UserInfoDto();
        pDto.setUser_email(CmmUtil.nvl(email.trim())); /* 공백 제거 및 널 처리 후 매개변수로 */

        int res = 0;
        res = userLoginService.checkOverlapForEmail(pDto);
        return res;
    }
}
