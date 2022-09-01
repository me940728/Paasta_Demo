package RestAPIServer.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void 이름확인() throws Exception{
		// Given
		String name = "최별규";
		Boolean bol = null;
		// When
		bol = name.equals("최별규");
		// Then
		System.out.print(bol == true? "이름은 최별규 입니다." : "다른 사람입니다.");
	}

}
