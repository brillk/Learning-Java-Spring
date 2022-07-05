package hi.hellospring.repository;

import hi.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 스프링 데이터 JPA는 인터페이스에 repository를 받고 있으면
// 구현체를 자동으로 스프링 빈에 만들어 준다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
    // ???
}
