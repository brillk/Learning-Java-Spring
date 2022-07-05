package hi.hellospring;

import hi.hellospring.repository.JdbcTemplateMemberRepository;
import hi.hellospring.repository.JpaMemberRepository;
import hi.hellospring.repository.MemberRepository;
import hi.hellospring.repository.MemoryMemberRepository;
import hi.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private  final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 생성자 주입 으로 DI 설정
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    /*
    실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다
    정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록된다

   @Autowired를 통한 DI는 helloController, MemberService와 같이 스프링이 관리하는 객체에서만 동작함
   스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
    */
    //이렇게 자바코드로 스프링 빈을 쓰게 되면 변수를 하나만 바꿔도 모두 적용되기 때문에 편하다
//    @Bean
//    public MemberRepository memberRepository() {
//        //
//    }

}
