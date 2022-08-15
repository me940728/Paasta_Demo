package RestAPIServer.demo.mapper;

import RestAPIServer.demo.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 최별규
 * @version 1.1 로그인 DTO
 * => 로그인 동작을 위한 메퍼
 */
@Mapper
@Repository
public interface UserLoginMapper {
    UserInfoDTO getUserInfo(UserInfoDTO uDTO); // => 사용자 정보 가져오기
    UserInfoDTO getUserInfoKakao(UserInfoDTO uDTO); // => 이메일로 사용자 정보 가져오기
}
