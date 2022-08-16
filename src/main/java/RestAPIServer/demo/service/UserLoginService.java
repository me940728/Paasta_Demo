package RestAPIServer.demo.service;

import RestAPIServer.demo.dto.UserInfoDTO;

/**
 * @author 최별규
 * @version 1.1 로그인 DTO
 * =>
 */
public interface IUserLoginService extends IKakaoLoginService{
    int getUserInfo(String user_id, String password); // => 로그인을 위한 메서드
    UserInfoDTO kakaoLoginProc(UserInfoDTO pDTO); // => 엑세스토큰으로 받은 이메일로 로그인 시도하는 메세드
}