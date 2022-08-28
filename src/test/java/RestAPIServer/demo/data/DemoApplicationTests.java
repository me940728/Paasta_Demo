package RestAPIServer.demo.data;

import RestAPIServer.demo.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserLoginService userLoginService;

	@Test
	void 서비스테스트() throws Exception{
		// Given
		String admin = "admin";
		String password = "1234";
		// When
		int res = userLoginService.getUserInfo(admin, password);
		// Then
		assertEquals(res, 1);
	}

}
