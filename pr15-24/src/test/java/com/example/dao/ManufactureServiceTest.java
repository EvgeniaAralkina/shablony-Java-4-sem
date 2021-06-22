package com.example.dao;

import com.example.Manufacture;
import com.example.repository.ManufactureRepository;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class ManufactureServiceTest {
    @Autowired
    ManufactureService ser;
    //@Mock
    @MockBean
    private ManufactureRepository reps;
    @Captor
    ArgumentCaptor<Manufacture> captor;



    @Test
    void index() {
        Manufacture i = new Manufacture();
        i.setName("name1");
        Manufacture i1 = new Manufacture();
        i.setName("name2");
        Mockito.when(reps.findAll()).thenReturn(List.of(i, i1));
        //ManufactureService ser = new ManufactureService(reps);

        Assertions.assertEquals(2, ser.index().size());
    }

    @Test
    void show() {
        Manufacture i = new Manufacture();
        i.setName("name1");
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
        Manufacture i = new Manufacture();
        i.setName("name");
        i.setId(0L);
        //ManufactureService ser = new ManufactureService(reps);
        ser.save(i);
        Mockito.verify(reps).save(captor.capture());
        Manufacture captured = captor.getValue();
        Assertions.assertEquals("name", captured.getName());
    }

    @Test
    void delete() {
        Manufacture i = new Manufacture();
        i.setName("name");
        i.setId(0L);
        //ManufactureService ser = new ManufactureService(reps);
        Mockito.doReturn(null)
                .when(reps)
                .findById(0L);
        ser.delete(0L);
        Mockito.verify(reps, Mockito.times(1)) .findById(0L);
    }

    @Test
    void getManufactureFilteredByName() {
        List<Manufacture> departures = ser.getManufactureFilteredByName();
        Mockito.verify(reps,Mockito.times(1)).findAllByOrderByName();
    }

    @Test
    void getManufactureFilteredByAddress() {
        List<Manufacture> departures = ser.getManufactureFilteredByAddress();
        Mockito.verify(reps,Mockito.times(1)).findAllByOrderByAddress();
    }
}