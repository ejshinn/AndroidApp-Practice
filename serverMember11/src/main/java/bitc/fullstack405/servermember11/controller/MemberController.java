package bitc.fullstack405.servermember11.controller;

import bitc.fullstack405.servermember11.model.Member;
import bitc.fullstack405.servermember11.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 전체보기
    @GetMapping("/list")
    public List<Member> getList() {
        return memberService.findAll();
    }

    // 추가
    @PostMapping("/insert")
    public Member insert(@RequestBody Member member) {
        return memberService.save(member);
    }

    // 수정
    @PutMapping("/update/{id}")
    public Member update(@PathVariable long id, @RequestBody Member member) {
        return memberService.update(id, member);
    }

    // 삭제
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        memberService.delete(id);
    }
}