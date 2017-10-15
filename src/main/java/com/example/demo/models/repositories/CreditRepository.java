package com.example.demo.models.repositories;

import com.example.demo.models.CreditModel;
import org.apache.tomcat.jni.Local;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CreditRepository extends CrudRepository<CreditModel, Integer> {
        List<CreditModel> findBySalaryGreaterThan(int howMany);
        List<CreditModel> findByPeriodGreaterThanAndIdGreaterThan(int period, int id);
        List<CreditModel> findByDateBetween(LocalDateTime start, LocalDateTime stop);
}
