package bitc.fullstack405.androidphone.controller;

import bitc.fullstack405.androidphone.model.Phone;
import bitc.fullstack405.androidphone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    // 전체보기
    @GetMapping("/list")
    public List<Phone> list() {
        return phoneService.list();
    }

    // 추가
    @PostMapping("/insert")
    public Phone insert(@RequestBody Phone phone) { // @RequestBody: JSON 형태로 값으로 받아와서 JSON 형태로 값을 반환함
        System.out.println("insert");

        return phoneService.insert(phone);
    }

    // 수정
    @PutMapping("/update/{id}")
    public Phone update(@PathVariable Long id, @RequestBody Phone phone){
        return  phoneService.update(id, phone);
    }

    // 삭제
    @DeleteMapping("/delete/{num}")
    public void delete(@PathVariable long num) {
        System.out.println("delete");

        phoneService.delete(num);
    }
}
