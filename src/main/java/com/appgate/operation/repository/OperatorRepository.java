package com.appgate.operation.repository;

import com.appgate.operation.data.OperatorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatorRepository extends JpaRepository<OperatorData, Long> {

    OperatorData findFirstByOrderByIdValueAsc();
    List<OperatorData> findByIdSession(String idSession);
}
