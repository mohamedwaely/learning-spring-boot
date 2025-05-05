package com.training.restapi_spring_boot.app.dao;

import com.training.restapi_spring_boot.app.models.Trainee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TraineeDAOImp implements TraineeDAO {
    EntityManager entityManager;

    @Autowired
    public TraineeDAOImp (EntityManager em){
        this.entityManager = em;
    }
    @Override
    @Transactional
    public void save(Trainee trainee){
        entityManager.persist(trainee);
    }

    @Override
    public Trainee getTraineeById(Long id){
        return entityManager.find(Trainee.class, id);
    }

    @Override
    public String getLastName(String email){
        TypedQuery<Trainee> traineeQuery = entityManager.createQuery("select t from Trainee t WHERE t.email=:email ", Trainee.class);
        traineeQuery.setParameter("email", email);
        return traineeQuery.getResultList().getFirst().getLastName();
    }

}
