package com.santander.banco811.controller;

import com.santander.banco811.dto.transacao.TransacaoRequest;
import com.santander.banco811.dto.transacao.TransacaoResponse;
import com.santander.banco811.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping("{idContaRemetente}")
    public TransacaoResponse create(
            @RequestBody TransacaoRequest transacaoRequest,
            @PathVariable Integer idContaRemetente
    ){
        return transacaoService.create(transacaoRequest, idContaRemetente);
    }

    @GetMapping
    public List<TransacaoResponse> listAll(){
        return transacaoService.findAll();
    }
}
