package tcon.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToiletRepository extends JpaRepository<ToiletEntity,Integer> {


    @Query(value = "select * from total_toilet_info where (t_address_1st like %:keyword1% and t_address_1st like %:keyword2%) or (t_address_2nd like %:keyword1% and t_address_2nd like %:keyword2%) "   , nativeQuery = true)
    List<ToiletEntity> findallt_address_2nd( String keyword1, String keyword2 );
}

//select * from toilet.total_toilet_info where (t_address_1st like '%대구%' and t_address_1st like '%남구%') or (t_address_2nd like '%대구%' and t_address_2nd like '%남구%')