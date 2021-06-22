package com.example.repository;

import com.example.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    List<Worker> findAllByOrderByFirstName();
    List<Worker> findAllByOrderByLastName();
    List<Worker> findAllByOrderByMiddleName();
    List<Worker> findAll();
    Optional<Worker> findById(Long id);
    Worker save(Worker worker);
}
