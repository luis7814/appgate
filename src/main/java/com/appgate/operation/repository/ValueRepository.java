package com.appgate.operation.repository;

import com.appgate.operation.data.ValueData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ValueRepository extends JpaRepository<ValueData, Long> {

    List<ValueData> findByIdSession(String idSession);

}
