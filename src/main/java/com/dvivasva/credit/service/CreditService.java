package com.dvivasva.credit.service;

import com.dvivasva.credit.dto.CreditDto;
import com.dvivasva.credit.entity.Credit;
import com.dvivasva.credit.repository.ICreditRepository;
import com.dvivasva.credit.utils.CreditUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final static Logger logger= LoggerFactory.getLogger(CreditService.class);

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private  final ICreditRepository iCreditRepository;

    public Mono<CreditDto> create(Mono<CreditDto> creditDtoMono){
        logger.info("inside methode create ");
        return creditDtoMono.map(CreditUtil::dtoToEntity)
                .flatMap(reactiveMongoTemplate::save)
                .map(CreditUtil::entityToDto);
    }
    public Flux<Credit>lisCreditFlux(){
        return iCreditRepository.findAll();
    }



}
