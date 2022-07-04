package hi.hellospring.service;

import hi.hellospring.domain.Member;
import hi.hellospring.repository.MemberRepository;
import hi.hellospring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {
// Ctrl + Shift + T = 새로운 테스트 만들기
    private final MemberRepository memberRepository;

    // 파일 마다 새로운 객체를 생성하는 게 아닌 선언된 곳을 가져온다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 이 경우를 Dependency Injection? DI

    // 회원가입
    public Long join(Member member) {

        validateExistUser(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    } // Ctrl + Alt + M = Extract

    private void validateExistUser(Member member) {
        memberRepository.findByName(member.getName())
          .ifPresent( m -> {
              throw new IllegalStateException("이미 존재하는 회원입니다");
          });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 하나의 유저 찾기
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}