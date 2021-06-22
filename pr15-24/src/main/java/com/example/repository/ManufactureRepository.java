package com.example.repository;

import com.example.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
    List<Manufacture> findAllByOrderByName();
    List<Manufacture> findAllByOrderByAddress();
    List<Manufacture> findAll();
    Optional<Manufacture> findById(Long id);
    Manufacture save(Manufacture manufacture);
}
