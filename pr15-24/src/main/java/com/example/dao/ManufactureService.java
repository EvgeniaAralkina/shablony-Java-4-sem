package com.example.dao;


import com.example.Manufacture;
import com.example.repository.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Slf4j
@Transactional
public class ManufactureService { //ManufactureService
    //private final SessionFactory sessionFactory;
    //private Session session;

    @Autowired
    private ManufactureRepository manufactureRepository;

    public ManufactureService(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    public List<Manufacture> index(){
        log.info("Find all manufactures");
        return (List<Manufacture>)manufactureRepository.findAll();
    }

    public Manufacture show(Long id) {
        if (manufactureRepository.findById(id)!=null)
            return manufactureRepository.findById(id).orElseThrow(() ->
                    new IllegalStateException("Manufacture with this id not found"));
        else
            return null;
        //
        //log.info("Show manufacture with id: {}", id);
        //return manufactureRepository.findById(id).orElseThrow(() ->
        //        new IllegalStateException("Manufacture with this id not found"));
    }

    public void save(Manufacture manufacture) {
        log.info("Save manufacture {}", manufacture);
        manufactureRepository.save(manufacture);
    }

    public void delete(Long id) {
        if (manufactureRepository.findById(id)!=null){
            log.info("Delete manufacture with id: {}", id);
            Manufacture manufacture = manufactureRepository.findById(id).orElseThrow(() ->
                    new IllegalStateException("Manufacture with this id not found"));
            manufactureRepository.delete(manufacture);
            System.out.println("DEL!");
        }else
            System.out.println(3);
        //
        /*
        log.info("Delete manufacture with id: {}", id);
        Manufacture manufacture = manufactureRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Manufacture with this id not found"));
        manufactureRepository.delete(manufacture);
        System.out.println("DEL!");

         */
    }

    public List<Manufacture> getManufactureFilteredByName(){
        log.info("Show all manufactures filtered by name");
        return manufactureRepository.findAllByOrderByName();
    }

    public List<Manufacture> getManufactureFilteredByAddress(){
        log.info("Show all manufactures filtered by address");
        return manufactureRepository.findAllByOrderByAddress();
    }

    /*
    public ManufactureDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@PostConstruct
    //void init() {
    //    session = sessionFactory.openSession();
    //}

    public List index() {
        session = sessionFactory.openSession();
        return session.createQuery("from Manufacture").list();
    }

    public Manufacture show(Long id) {
        session = sessionFactory.openSession();
        return session.get(Manufacture.class, id);
    }

    public void save(Manufacture manufacture) {
        session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.save(manufacture);
        transaction.commit();
        //session.flush();
        session.close();
    }


    public void delete(Long id) {
        session = sessionFactory.openSession();
        Manufacture manufacture = session.get(Manufacture.class, id);
        var transaction = session.beginTransaction();
        session.delete(manufacture);
        transaction.commit();
        //session.flush();
        session.close();
        System.out.println("DEL!");
    }
    //pr17
    public List<Manufacture> getManufactureFilteredBySmth(String smth){
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Manufacture> manufactureCQ = builder.createQuery(Manufacture.class);
        Root<Manufacture> root = manufactureCQ.from(Manufacture.class);
        manufactureCQ.select(root).orderBy(builder.asc(root.get(smth)));
        Query<Manufacture> query = session.createQuery(manufactureCQ);
        return query.getResultList();
    }
     */
}



