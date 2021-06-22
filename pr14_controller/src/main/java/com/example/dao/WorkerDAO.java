package com.example.dao;

import com.example.Manufacture;
import com.example.Worker;
import com.example.config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerDAO {
    private List<Worker> workers;
    private int ID = 0;

    {
        workers = new ArrayList<>();

        workers.add(new Worker("Stive", "William",  "Brown"));
        workers.add(new Worker("James", "Smith",  "Jones"));
        workers.add(new Worker("Levi", "Ackerman",  "Miller"));
        workers.add(new Worker("Maria", "Garcia",  "Davis"));
    }

    public List<Worker> index() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Worker").list();
    }

    public Worker show(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Worker.class, id);
    }


    public void save(Worker worker) {
        //person.setId(++PEOPLE_COUNT);
        //workers.add(worker);
        worker.setId((++ID));
        Session session = HibernateUtil.getSessionFactory().openSession(); //открываем сессию
        session.beginTransaction();
        session.save(worker); //пользуемся ее методами
        session.flush();
        session.close();
    }

    public void delete(int id) {
       // workers.removeIf(p -> p.getFirstName().equals(name));
        Session session = HibernateUtil.getSessionFactory().openSession();
        Worker worker = session.get(Worker.class, id);
        session.beginTransaction();
        session.delete(worker);
        session.flush();
        session.close();
        System.out.println("DEL!");
    }

   /* public Manufacture getManufactureByWorker(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Worker worker = session.get(Worker.class, id);
        return worker.manufacture;
    }*/

    public Manufacture getManufactureByWorker(int my_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Worker where id =" +my_id, Worker.class).setParameter("id",my_id).getSingleResult().getManufacture();
    }


}
