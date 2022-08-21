package RestAPIServer.demo.controller;

import RestAPIServer.demo.dto.UserInfoDTO;
import RestAPIServer.demo.service.UserLoginService;
import RestAPIServer.demo.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 최별규
 * @version 1.1 로그인 컨트롤러
 * => 사용자 로그인 컨트롤러
 */
@Slf4j
@Controller
public class UserLoginController {
    @Resource(name = "UserLoginServiceImpl")
    private UserLoginService userLoginService;

    /* 단순 로그인 페이지를 리턴  */
    @GetMapping(value = "/loginPage")
    public String loginPage() throws Exception{
        log.info(this.getClass().getName() + ".Login Page load Start");
        log.info(this.getClass().getName() + ".Login Page load End");
        return "/user/userLoginPage";
    }
    //=> 로그인 처리 프로세스 POST
    @PostMapping(value = "/loginPage/loginProc")
    public String loginProc(HttpServletRequest request, ModelMap model) throws Exception{
        log.info(this.getClass().getName() + ".Login Process Start");
        /* CmmUtil은 데이터 무결성 1차 처리(공백) 확인을 위한 사용자 정의 클래스 생략해도 무방 */
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        log.info("===================================user_id : " + user_id);

        String password = CmmUtil.nvl(request.getParameter("password")); //=> 해쉬 처리 해야함
        log.info("====================================password : " + password);

        int res = userLoginService.getUserInfo(user_id, password);
        log.info("======================Login Success ? : " + res);

        String msg = "Login fail";
        String url = "/";
        if(res == 1){ msg = "Login Success"; url = "/index"; }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        log.info(this.getClass().getName() + ".Login Process End");
        return "/redirect";
    }
    // => 카카오 로그인 인증코드 발급화면 매핑
    @RequestMapping(value="/kakaoGetAuthToken")
    public String kakaoLoginProc(ModelMap model) throws Exception {
        log.info(this.getClass().getName() + "kakaoLogin Start!");

        String forKakao = userLoginService.getAuthCode(); // 카카오 접속을 위한 실행
        log.info(forKakao);

        String msg = "카카오 로그인 시도";
        String url = forKakao;

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".kakaoLogin End");
        return "/redirect";
    }
    // => 카카오 로그인 후 엑세스 토큰 발급
    @GetMapping(value = "/kakaoLogin", produces = "apllication/json")
    public String kakaoAuthCodeProc(@RequestParam("code") String code, HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, HttpSession session) throws Exception {
        log.info(this.getClass().getName() + "kakaoAuthCodeProc Start!!!");
        String kakaoToken = userLoginService.getAccessToken(code);
        log.info("엑세스 토큰 : " + kakaoToken);

        Map<String, Object> result = userLoginService.getUserInfo(kakaoToken);
        String kakaoEmail = result.get("kakaoEmail").toString();
        log.info("카카오 이메일 : " + kakaoEmail);

        UserInfoDTO pDTO = new UserInfoDTO(); // 값 전달 용
        UserInfoDTO rDTO = new UserInfoDTO(); // 값 받아오기 용

        pDTO.setUser_email(kakaoEmail);
        rDTO = userLoginService.kakaoLoginProc(pDTO); // userService에서 MAPPER를 연결하여 값 받아옴

        String user_name = "";
        String user_id = "";
        String msg = "서비스에 회원가입 먼저 해주세요!";
        String url = "/loginPage";

        if(rDTO != null){
            user_id = rDTO.getUser_id();
            user_name = rDTO.getUser_name();
            log.info("유저 이름 : " + user_id);
            log.info("유저 아이디 : " + user_name);
            msg = "카카오 로그인 성공 되었습니다.";
            url = "/index";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            /* 로그아웃 처리 시, 사용할 토큰 값 */
            session.setAttribute("kakaoToken", kakaoToken); //세션 값으로 정보 유지
            session.setAttribute("user_id", user_id);
            session.setAttribute("user_name", user_name);
        } else {
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
        }
        log.info(this.getClass().getName() + "kakaoAuthCodeProc End");
        return "/redirect";
    }
    /*
    //=> 카카오 친구목록 불러오기 Test
    @GetMapping(value = "/kakaoFriendList")
    public String kakaoFriendListRequest(HttpServletRequest request, HttpSession session) throws Exception{
        log.info(this.getClass().getName() + "kakao Request Friend List Start");

        String accessToken = session.getAttribute("kakaoToken").toString();
        log.info(kakaoFriend.requestFriendList(accessToken, 5));

        log.info(this.getClass().getName() + "kakao Request Friend List End");
        return "";
    }
    */

}
