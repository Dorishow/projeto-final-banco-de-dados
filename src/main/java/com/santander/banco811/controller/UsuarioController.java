package com.santander.banco811.controller;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<UsuarioResponse> getAll(){
        return usuarioService.getAll();
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> getByName(@PathVariable String nome){
        return usuarioService.getUserByNome(nome);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public UsuarioResponse getById(@PathVariable Integer id){
        return usuarioService.getUserById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public  UsuarioResponse updateById(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.updateById(id, usuarioRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse deleteById(@PathVariable Integer id){
        return usuarioService.deleteById(id);
    }

    @GetMapping("/paginado")
    @ResponseStatus(HttpStatus.OK)
    public Page<Usuario> getAllPaginated(
            @RequestParam(required = false, defaultValue = "0") int pagina,
            @RequestParam(required = false, defaultValue = "1") int qtdElementos
    ){
        return usuarioService.getAllPaginated(pagina, qtdElementos);
    }

}
