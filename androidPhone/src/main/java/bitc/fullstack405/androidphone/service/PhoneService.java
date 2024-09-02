package bitc.fullstack405.androidphone.service;

import bitc.fullstack405.androidphone.model.Phone;
import bitc.fullstack405.androidphone.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    // 전체보기
    public List<Phone> list() {
        return phoneRepository.findAll();
    }

    // 추가
    public Phone insert(Phone phone) {
        return phoneRepository.save(phone);
    }

    // 수정
    @Transactional
    public Phone update(Long id, Phone phone){
        //1 영속성 컨텍스트에 있는  id  로  phone 객체 구하기
        Phone p = phoneRepository.findById(id).get();  // p <- 수정 전 객체

        //2. 그 객체를 수정하기 <--더티체킹
        p.setPhone(phone.getPhone());  // phone <- 수정할 내용이 담긴 객체
        p.setName(phone.getName());
        return  p;

    }

    // 삭제
    public void delete(long num) {
        phoneRepository.deleteById(num);
    }
}
