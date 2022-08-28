package RestAPIServer.demo.data.dao.impl;

import RestAPIServer.demo.data.dao.UserLoginDAO;
import RestAPIServer.demo.data.dto.UserInfoDto;
import RestAPIServer.demo.data.entity.UserInfo;
import RestAPIServer.demo.data.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @author 최별규
 * @version 1.1 로그인 DAO 구현체
 * => ##
 */
@Repository
public class UserLoginDAOImpl implements UserLoginDAO {
    private final UserLoginRepository userInfoRepository;
    @Autowired
    UserLoginDAOImpl(UserLoginRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;
    }
    /* 사용자 정보 가져오기 22.08.28 new Choi */
    @Override
    public UserInfo getUserInfo(UserInfoDto pDto) {
        UserInfo uDto = userInfoRepository.findByUserIdAndUserPwd(pDto.getUser_id(), pDto.getPassword());
        return uDto;
    }
    /* 이메일로 사용자 정보 가져오기 22.08.28 new Choi */
    @Override
    public UserInfo getUserInfoKakao(UserInfoDto pDto) {
        return null;
    }
}
