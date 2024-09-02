package bitc.fullstack405.servermember11.repository;

import bitc.fullstack405.servermember11.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 없어도 됨
public interface MemberRepository extends JpaRepository<Member, Long> {
}
