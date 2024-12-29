package com.macaron.ezordermw.repository;


import com.macaron.ezordermw.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, String> {


    @Query(value = "Select * from order_list where order_no =:orderNo", nativeQuery = true)
    List<OrderList> findByOrderNo(String orderNo);

    @Query(value = "select agent_phone from order_list where custom_phone = :customPhone order by modify_time desc limit 1", nativeQuery = true)
    String findByCustomPhoneLimit(String customPhone);


    @Query(value = "select count(*) from order_list where custom_phone = :customPhone and sms_tag='2'", nativeQuery = true)
    Long findByCustomPhoneTotal(String customPhone);
}
