package com.training.restapi_spring_boot.app.dao;

import com.training.restapi_spring_boot.app.models.Trainee;

import java.util.List;

public interface TraineeDAO {
    void save(Trainee trainee);
    Trainee getTraineeById(Long id);

    String getLastName(String email);
}
