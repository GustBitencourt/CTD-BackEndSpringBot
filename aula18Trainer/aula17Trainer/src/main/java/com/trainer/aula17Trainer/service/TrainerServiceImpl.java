package com.trainer.aula17Trainer.service;

import com.trainer.aula17Trainer.domain.Trainer;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(
                new Trainer("Gustavo"),
                new Trainer("Simone"),
                new Trainer("Simaria")
        );
    }
}
