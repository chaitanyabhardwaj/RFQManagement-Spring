package com.mrfq.rfqmodule.repository;

import com.mrfq.rfqmodule.model.Rfq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RfqRepo extends JpaRepository<Rfq, Long> {

}
