package RestAPIServer.demo.data.repository;

import RestAPIServer.demo.data.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author 최별규
 * @version 1.1 로그인 JPA 레포지토리
 * => 엔터티가 생성한 데이터베이스에 접근하는 객체(myBatis의 Mapper와 같은 역할),
 * => 상속을 통한 별도 메서드 구현없이 기능 사용 가능
 *
 */                              /* 쥬네릭스에 대상 엔터티와 @Id 필드의 타입을 명시 */
public interface UserLoginRepository extends JpaRepository<UserInfo, String> {
    /* 로그인 메서드 재정의 */
    UserInfo findByUserIdAndUserPwd(String userId, String password);
}
