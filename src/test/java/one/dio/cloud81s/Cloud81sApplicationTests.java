package one.dio.cloud81s;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Cloud81sApplicationTests {
	public int n = 15;

	@Test
	void contextLoads() {
		for (int i = 1; i <= n ; i++) {
			//System.out.println(i + "Resto" + i % 3);
			if(((i % 3) == 0) && ((i % 5) == 0))  {
				System.out.println("FizzBuzz");
			}else if ((i % 3) == 0){
				System.out.println("Fizz");
			}else if ((i % 5) == 0){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
		}

	}

}
