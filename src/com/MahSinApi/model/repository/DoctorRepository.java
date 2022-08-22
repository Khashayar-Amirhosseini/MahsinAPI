package com.MahSinApi.model.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DoctorRepository {
@PersistenceContext
private EntityManager entityManager;

}
