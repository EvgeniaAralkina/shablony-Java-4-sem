package com.example.dao;

import com.example.Manufacture;
import com.example.config.HibernateUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import org.hibernate.Session;

@Component
public class ManufactureDAO {
    private List<Manufacture> manufactures;
    private int ID = 0;
   /* {
        manufactures = new ArrayList<>();

        manufactures.add(new Manufacture("Apple", "America"));
        manufactures.add(new Manufacture("Samsung", "America"));
        manufactures.add(new Manufacture("HP", "America"));
        manufactures.add(new Manufacture("PlayStation", "America"));
    }*/

    public List<Manufacture> index() {

       // System.out.println(manufactures);
        //return manufactures;
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Manufacture").list();
        //return session.createCriteria(Manufacture.class).list();
    }

    public Manufacture show(int id) {
       // return manufactures.stream().filter(manufacture -> manufacture.getName().equals(name)).findAny().orElse(null);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Manufacture manufacture = session.get(Manufacture.class, id);
        return manufacture;
    }

    public void save(Manufacture manufacture) {
        //person.setId(++PEOPLE_COUNT);
        //manufactures.add(manufacture);
        manufacture.setId(++ID);
        Session session = HibernateUtil.getSessionFactory().openSession(); //открываем сессию
        session.beginTransaction();
        session.save(manufacture);
        session.flush();
        session.close();
    }


    public void delete(int id) {
        //manufactures.removeIf(p -> p.getName().equals(name));
        Session session = HibernateUtil.getSessionFactory().openSession();
        Manufacture manufacture = session.get(Manufacture.class, id);
        session.beginTransaction();
        session.delete(manufacture);
        session.flush();
        session.close();
        System.out.println("DEL!");
    }
}
