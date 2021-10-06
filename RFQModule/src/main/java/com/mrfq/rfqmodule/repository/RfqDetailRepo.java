package com.mrfq.rfqmodule.repository;

import com.mrfq.rfqmodule.model.RfqDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RfqDetailRepo extends JpaRepository<RfqDetail, Long> {

    List<RfqDetail> getRfqDetailsByRfqId(Long rfqId);

}
