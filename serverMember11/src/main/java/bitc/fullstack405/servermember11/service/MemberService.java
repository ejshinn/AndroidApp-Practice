package bitc.fullstack405.servermember11.service;

import bitc.fullstack405.servermember11.model.Member;
import bitc.fullstack405.servermember11.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 전체보기
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // 추가
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    // 수정
    @Transactional
    public Member update(long id, Member member) { // member : 수정할 내용이 있는 member
        // 1. 영속성 컨텍스트에 있는 member 객체 구하기
        Member m = memberRepository.findById(id).get(); // Optional이므로 get()으로 꺼냄(m은 수정 전 member 객체)
        
        // 2. 그 member 객체를 수정할 내용으로 바꿈 <- 더티체킹
        m.setEmail(member.getEmail());
        m.setName(member.getName());
        m.setPhone(member.getPhone());

        return m; // 수정된 member 객체인 m 리턴
    }

    // 삭제
    public void delete(long id) {
        memberRepository.deleteById(id);
    }
}
