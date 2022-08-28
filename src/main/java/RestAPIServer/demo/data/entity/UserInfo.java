package RestAPIServer.demo.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

/**
 * @author 최별규
 * @version 1.1 사용자 정보 엔터티
 * => ##
 */
@Entity /* 이 클래스가 JPA 엔터티(테이블 매핑 객체) 라는 것을 알리는 에너테이션 */
@Table(name = "USER_INFO") /* => 클래스 이름과 테이블 이름이 다를 경우 지정하는 에너테이션 */
@Getter /* 롬복 사용 */
@Setter /* 롬복 사용 */
public class UserInfo {
    @Id /* 테이블의 칼럼과 매핑 모든 엔터티는 ID가 필요함 pk가 유저 이메일 이기 때문에 붙힘*/
    @Column(nullable = false, name="user_email") /* 엔터티 필드에서 @Column은 자동을 생성됨 별도 옶견 줄거 아니면 생략 가능 */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_email; /* 사용자 이메일 */
    @Column(name="user_id")
    private String userId; /* 사용자 아이디 */
    @Column(name="password")
    private String userPwd; /* 사용자 패스워드 */
    private String user_name; /* 사용자 이름 */
    private String user_addr; /* 사용자의 주소 */
    //private String user_access_token; /* 카카오 로그인 시 사용할 토큰 필드 */
    //private String exists_yn; /* 회원 가입 중복 여부 확인 필드 */

}
