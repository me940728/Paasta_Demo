package RestAPIServer.demo.data.mapper;

import RestAPIServer.demo.data.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 최별규
 * @version 1.1 로그인 DTO
 * => 로그인 동작을 위한 마이바티스 메퍼
 */
@Mapper /* Mapper 에너테이션은 이 객체가 메퍼 역할을 한다는 표시 역할만 수행한다. */
public interface UserLoginMapper {
    UserInfoDto getUserInfo(UserInfoDto uDTO); // => 사용자 정보 가져오기
    UserInfoDto getUserInfoKakao(UserInfoDto uDTO); // => 이메일로 사용자 정보 가져오기
}
