package RestAPIServer.demo.data.dao;

import RestAPIServer.demo.data.dto.UserInfoDto;
import RestAPIServer.demo.data.entity.UserInfo;

/**
 * @author 최별규
 * @version 1.1 로그인 DAO 인터페이스
 * => ##
 */
public interface UserLoginDAO {
    UserInfo getUserInfo(UserInfoDto pDto); //=> 사용자 정보 가져오기
    UserInfo getUserInfoKakao(UserInfoDto pDto); // => 이메일로 사용자 정보 가져오기
}
