package com.example.demo.repository;

import com.example.demo.entity.financial_statistics.Financial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFinancialRepository extends JpaRepository<Financial,Integer> {
@Query(value="select * from financial where month like concat('%',:month,'%')" +
        " and year like concat('%',:year,'%') ",nativeQuery = true)
    Page<Financial> search(Pageable pageable, @Param("month") String month, @Param("year") String year);
}
