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
    /**
     * @author 최별규
     * @version 1.1 이메일(PK)로 중복 가입 확인 비동기 메서드
     * @param UserInfoDto pDto
     * @return int
     * @date 2022.09.03
     */
    @Override
    public int checkOverlapForEmail(UserInfoDto pDto) {
        int res = 0;
        UserInfo uDto = new UserInfo();
        try {
            uDto = userInfoRepository.findByUserEmail(pDto.getUser_email());
        } catch (Exception e) {
            if (uDto == null) {
                uDto = new UserInfo();
            }
        } finally {
            res = uDto.getUserEmail().equals(pDto.getUser_email()) || uDto == null? 1 : 0;
        }
        return res;
    }
}
