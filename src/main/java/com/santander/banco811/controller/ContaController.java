package com.santander.banco811.controller;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ContaResponse create(@RequestBody ContaRequest contaRequest){
        return contaService.create(contaRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    List<ContaResponse> getAll(){
        return contaService.getAll();
    }
}
