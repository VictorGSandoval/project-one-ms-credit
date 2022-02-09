package com.dvivasva.credit.controller;

import com.dvivasva.credit.dto.CreditDto;
import com.dvivasva.credit.entity.Credit;
import com.dvivasva.credit.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/credit")
public class CreditController {
    private final CreditService creditService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Credit>>> getAllCredit() {
        Flux<Credit> list=this.creditService.lisCreditFlux();
        return  Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreditDto> create(@RequestBody Mono<CreditDto> creditDtoMono) {
        return this.creditService.create(creditDtoMono);
    }

}
