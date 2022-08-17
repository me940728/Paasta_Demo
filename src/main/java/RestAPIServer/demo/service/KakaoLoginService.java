package RestAPIServer.demo.service;

import java.util.Map;

/**
 * @author 최별규
 * @version 1.1 로그인 DTO
 * => 카카오 로그인을 위한 비즈니스 로직
 */
public interface KakaoLoginService {
    String getAuthCode() throws Exception; // => 카카오 로그인 시도를 위한 인증 코드 받는 메서드
    public String getAccessToken(String authCode) throws Exception; // => 인증코드를 통해 엑세스 토큰을 발급하는 메서드
    public Map<String, Object> getUserInfo(String accessToken) throws Exception; // => 엑세스 토큰으로 유저 정보 가져오기

}
