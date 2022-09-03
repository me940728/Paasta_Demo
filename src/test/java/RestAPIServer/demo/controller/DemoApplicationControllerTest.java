package RestAPIServer.demo.controller;

import RestAPIServer.demo.service.UserLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebAppConfiguration
@WebMvcTest(controllers = UserController.class)
class DemoApplicationControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private UserLoginService userServiec;

	@Test
	void 로그인테스트하기() throws Exception{
		// Given
		String admin = "admin";
		String password = "1234";
		given(userServiec.getUserInfo(admin, password)).willReturn(1);
		// When
		mvc.perform(post("/loginPage/loginProc?user_id=" + admin +"&password=" + password))
				// Then
				.andExpect(status().isOk()).andDo(print());


	}

}
