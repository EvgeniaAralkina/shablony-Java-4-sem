package com.example.dao;

import com.example.Worker;
import com.example.repository.WorkerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmailServiceTest {

    @Autowired
    EmailService ser;
    //@Mock
    @MockBean
    private JavaMailSender javaMailSender;
    @Captor
    ArgumentCaptor<Worker> captor;

    @Test
    void sendEmail() {
        Mockito.doNothing()
                .when(javaMailSender)
                .send((MimeMessage) ArgumentMatchers.any());
        ser.sendEmail("some message");
        Mockito.verify(javaMailSender).send((SimpleMailMessage) ArgumentMatchers.any());
    }
}