package com.dvivasva.credit.repository;

import com.dvivasva.credit.entity.Credit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends ReactiveCrudRepository<Credit, String> {

}
