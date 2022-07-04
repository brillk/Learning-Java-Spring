package hi.hellospring.repository;

import hi.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

   //테스트가 끝날때 마다 깨끗히 치워야 한다
    @AfterEach // 함수 하나가 끝날때마다 실행
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // optional로 있는 값은 get()으로 가져온다
        //Assertions.assertEquals(member, result); 예시 1
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        // 각 함수는 따로 실행된다
        // findall이 살행되고, findbyname이 실행되는데, 이미 member1의 값이 정해져있다
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result =  repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
