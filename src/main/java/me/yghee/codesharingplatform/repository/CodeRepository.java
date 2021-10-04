package me.yghee.codesharingplatform.repository;

import me.yghee.codesharingplatform.domain.Code;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CodeRepository extends CrudRepository<Code, Long>{
    Optional<Code> findById(Long id);

    List<Code> findTop10ByOrderByIdDesc();
}
