package com.santander.banco811.controller;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.enums.TipoConta;
import com.santander.banco811.projection.ContaView;
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
    ContaResponse create(@RequestBody ContaRequest contaRequest) {
        return contaService.create(contaRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    List<ContaResponse> getAll() {
        return contaService.getAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ContaResponse updateById(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
        return contaService.updateById(id, contaRequest);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    ContaResponse getById(@PathVariable Integer id) {
        return contaService.getById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ContaResponse deleteById(@PathVariable Integer id) {
        return contaService.deleteById(id);
    }

    @GetMapping("/cpf_usuario/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    List<ContaResponse> getByUsuarioCpf(@PathVariable String cpf) {
        return contaService.getByUsuarioCpf(cpf);
    }

    @GetMapping("/agencia_cpf/{agencia}/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    List<ContaResponse> getByAgenciaAndCpf(@PathVariable Integer agencia, @PathVariable String cpf) {
        return contaService.findByAgenciaAndUsuario_cpf(agencia, cpf);
    }

    @GetMapping("/view")
    public List<ContaView> getAllContaViewByTipoConta(@RequestParam TipoConta tipoConta) {
        return contaService.getAllViewByTipoConta(tipoConta);
    }
}
