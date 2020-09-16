package one.dio.cloud81s.repository;

import one.dio.cloud81s.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
