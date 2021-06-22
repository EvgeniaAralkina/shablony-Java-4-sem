package com.example.dao;


import com.example.Manufacture;
import com.example.Worker;
import com.example.repository.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class WorkerService {
    //private final SessionFactory sessionFactory;
    //private Session session;
    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> index(){
        log.info("Find all workers");
        return (List<Worker>)workerRepository.findAll();
    }

    public Worker show(Long id) {
        if (workerRepository.findById(id)!=null)
            return workerRepository.findById(id).orElseThrow(() ->
                           new IllegalStateException("Worker with this id not found"));
        else
            return null;
        //log.info("Show worker with id: {}", id);
        //return workerRepository.findById(id).orElseThrow(() ->
         //       new IllegalStateException("Worker with this id not found"));
    }

    public void save(Worker worker) {
        log.info("Save worker {}", worker);
        workerRepository.save(worker);
    }

    public void delete(Long id) {
        if (workerRepository.findById(id)!=null){
            log.info("Delete worker with id: {}", id);
            Worker worker = workerRepository.findById(id).orElseThrow(() ->
                    new IllegalStateException("Worker with this id not found"));
            workerRepository.delete(worker);
            System.out.println("DEL!");
        }else
            System.out.println(3);
        /*
        log.info("Delete worker with id: {}", id);
        Worker worker = workerRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Worker with this id not found"));
        workerRepository.delete(worker);
        System.out.println("DEL!");

         */
    }

    public List<Worker> getWorkerFilteredByFirstName(){
        log.info("Show all workers filtered by first name");
        return workerRepository.findAllByOrderByFirstName();
    }

    public List<Worker> getWorkerFilteredByMiddleName(){
        log.info("Show all workers filtered by middle name");
        return workerRepository.findAllByOrderByMiddleName();
    }

    public List<Worker> getWorkerFilteredByLastName(){
        log.info("Show all workers filtered by last name");
        return workerRepository.findAllByOrderByLastName();
    }

    /*
    public WorkerDAO(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init(){ session = sessionFactory.openSession(); }

    public List<Worker> index() {
        return session.createQuery("from Worker").list(); }

    public Worker show(Long id) {
        return session.get(Worker.class, id);
    }

    public void save(Worker worker) {
        var transaction = session.beginTransaction();
        session.save(worker);
        transaction.commit();
    }

    public void delete(Long id) {
        Worker worker = session.get(Worker.class, id);
        var transaction = session.beginTransaction();
        session.delete(worker);
        transaction.commit();
        System.out.println("DEL!");
    }

    public Manufacture getManufactureByDog(Long id) {
        return session.get(Worker.class, id).getManufacture();
    }


    //pr17
    public List<Worker> getWorkerFilteredBySmth(String smth){
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Worker> workerCQ = builder.createQuery(Worker.class);
        Root<Worker> root = workerCQ.from(Worker.class);
        workerCQ.select(root).orderBy(builder.asc(root.get(smth)));
        Query<Worker> query = session.createQuery(workerCQ);
        return query.getResultList();
    }
     */
}
