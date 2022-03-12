package com.example.warehouse_rest_api.repository;

import com.example.warehouse_rest_api.entity.Input;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InputRepository extends JpaRepository<Input,Integer> {

    @Query("select i.code,i.date,i.facture_number,i.currency.name,i.warehouse.name from Input  i where i.id=?1")
    Optional<Input> getOneByIdJpql(Integer id);

//    List<Input> findAllBySupplier_IdAndDateBetween(Integer sId, Date from, Date to);
//
//    List<Input> findAllByDateBetween(Date from, Date to);


//    Page<Input> findAllByCreatedAtBeetwen(PageRequest of, Timestamp from, Timestamp to);
//
//    Slice<Input> findAllByCreated(Pageable pageable, Timestamp begin, Timestamp end);


}
