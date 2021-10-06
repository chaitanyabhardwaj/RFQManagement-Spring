package com.mrfq.rfqmodule.restclient;

import com.mrfq.rfqmodule.model.Part;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("GATEWAY-SERVICE")
public interface PartClient {

    @GetMapping("/plant/getPartById/{partId}")
    Part getPartById(@PathVariable Long partId);

    @GetMapping("/plant/getDemandIdByPartId/{partId}")
    Long getDemandIdByPartId(@PathVariable Long partId);

}
