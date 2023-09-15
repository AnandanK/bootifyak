package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Usermaster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsermasterRepository extends JpaRepository<Usermaster, Long> {
}
