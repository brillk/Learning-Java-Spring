package hi.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
/*
@SpringBootTest: 스프링 컨테이너와 테스트를 함께 실행한다
@Transactional: 테스트 케이스에 이 에노테이션이 있으면, 테스트 시작전에
트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다

DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
* */