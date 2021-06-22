package com.example.dao;

import com.example.Manufacture;
import com.example.Worker;
import com.example.repository.ManufactureRepository;
import com.example.repository.WorkerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class WorkerServiceTest {
    @Autowired
    WorkerService ser;
    //@Mock
    @MockBean
    private WorkerRepository reps;
    @Captor
    ArgumentCaptor<Worker> captor;

    @Test
    void index() {
        Worker i = new Worker();
        i.setFirstName("name1");
        Worker i1 = new Worker();
        i.setFirstName("name2");
        Mockito.when(reps.findAll()).thenReturn(List.of(i, i1));
        //ManufactureService ser = new ManufactureService(reps);

        Assertions.assertEquals(2, ser.index().size());
    }

    @Test
    void show() {
        Worker i = new Worker();
        i.setFirstName("name1");
        i.setId(0L);
        //ManufactureService ser = new ManufactureService(reps);
        Mockito.doReturn(null)
                .when(reps)
                .findById(0L);
        ser.show(0L);
        Mockito.verify(reps, Mockito.times(1)) .findById(0L);
    }

    @Test
    void save() {
        Worker i = new Worker();
        i.setFirstName("name");
        i.setId(0L);
        //ManufactureService ser = new ManufactureService(reps);
        ser.save(i);
        Mockito.verify(reps).save(captor.capture());
        Worker captured = captor.getValue();
        Assertions.assertEquals("name", captured.getFirstName());
    }

    @Test
    void delete() {
        Worker i = new Worker();
        i.setFirstName("name");
        i.setId(0L);
        //ManufactureService ser = new ManufactureService(reps);
        Mockito.doReturn(null)
                .when(reps)
                .findById(0L);
        ser.delete(0L);
        Mockito.verify(reps, Mockito.times(1)) .findById(0L);
    }

    @Test
    void getWorkerFilteredByFirstName() {
        List<Worker> departures = ser.getWorkerFilteredByFirstName();
        Mockito.verify(reps,Mockito.times(1)).findAllByOrderByFirstName();
    }

    @Test
    void getWorkerFilteredByMiddleName() {
        List<Worker> departures = ser.getWorkerFilteredByMiddleName();
        Mockito.verify(reps,Mockito.times(1)).findAllByOrderByMiddleName();
    }

    @Test
    void getWorkerFilteredByLastName() {
        List<Worker> departures = ser.getWorkerFilteredByLastName();
        Mockito.verify(reps,Mockito.times(1)).findAllByOrderByLastName();
    }
}