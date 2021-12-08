package com.Aula21APIRest.service;

import com.Aula21APIRest.service.impl.IPessoaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PessoaService implements IPessoaService {

    @Override
    public Integer calcularIdade(Integer dia, Integer mes, Integer ano) {
        LocalDate date = LocalDate.of(ano, mes, dia);
        Period period = Period.between(date, LocalDate.now());

        return Math.abs(period.getYears());
    }
}
