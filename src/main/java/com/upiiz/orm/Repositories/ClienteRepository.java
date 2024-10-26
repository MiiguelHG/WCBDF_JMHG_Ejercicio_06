package com.upiiz.orm.Repositories;

import com.upiiz.orm.Models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Aternativa a JpaRepositoy existe CrudRepository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    //Puedo generar metodos personalizados
    //@Query
}
