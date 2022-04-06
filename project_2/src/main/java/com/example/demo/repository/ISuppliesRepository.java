package com.example.demo.repository;
import com.example.demo.entity.financial_statistics.Supplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuppliesRepository extends JpaRepository< Supplies,Integer> {
    @Query(value="select * from supplies where start_day like concat('%',:startDay,'%')" +
            " and end_day like concat('%',:endDay,'%') ",nativeQuery = true)
    Page<Supplies> searchSupplies(Pageable pageable, @Param("startDay") String startDay, @Param("endDay") String endDay);
}
