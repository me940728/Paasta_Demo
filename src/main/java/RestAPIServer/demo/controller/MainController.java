package RestAPIServer.demo.controller;

import RestAPIServer.demo.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 최별규
 * @date 2022.09.03
 * @version 1.1 메인페이지 컨트롤러
 * => 사용자 메인페이지 컨트롤러
 */
@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {
    private final UserLoginService userLoginService;
    @Autowired
    MainController(UserLoginService userLoginService){
        this.userLoginService = userLoginService;
    }
    /**
     * @author 최별규
     * @version 1.1 로그인 후 메인대쉬보드 페이지 리턴
     * @param
     * @return /dashboard/index : String
     * @date 2022.09.03
     */
    /* 메인페이지 리턴 메서드 */
    @GetMapping(value = "/dashboard")
    public String mainPage(){
        log.info(this.getClass().getName() + ".main Page load Start");
        log.info(this.getClass().getName() + ".main Page load End");
        return "/dashboard/index";
    }
}
