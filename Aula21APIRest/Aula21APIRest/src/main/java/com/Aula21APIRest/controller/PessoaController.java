package com.Aula21APIRest.controller;

import com.Aula21APIRest.service.impl.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer calcularIdade(
            @PathVariable("dia") Integer dia,
            @PathVariable("mes") Integer mes,
            @PathVariable("ano") Integer ano){

        return pessoaService.calcularIdade(dia, mes, ano);
    }

}
