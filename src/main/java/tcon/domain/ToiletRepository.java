package tcon.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToiletRepository extends JpaRepository<ToiletEntity,Integer> {


    @Query(value = "select * from total_toilet_info where t_address_2nd like %:keyword%"  , nativeQuery = true)
    List<ToiletEntity> findallt_address_2nd( String keyword );
}
