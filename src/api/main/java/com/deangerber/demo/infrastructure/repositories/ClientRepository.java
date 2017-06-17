package com.deangerber.demo.infrastructure.repositories;

import com.deangerber.demo.infrastructure.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

}
