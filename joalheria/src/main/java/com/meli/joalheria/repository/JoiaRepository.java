package com.meli.joalheria.repository;

import com.meli.joalheria.entity.Joia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Integer> {

}
