package com.example.david.repository;

import com.example.david.model.Miembros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembrosRepository extends JpaRepository<Miembros, Long>{

}
// Al extender JpaRepository, ya tenemos métodos como save(), findAll(), findById(), de}