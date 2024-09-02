package bitc.fullstack405.androidphone.repository;

import bitc.fullstack405.androidphone.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> { // Long은 기본키(num) 유형
}