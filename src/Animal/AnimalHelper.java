package Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {
    EntityManagerFactory emf;
    EntityManager em;

    public  AnimalHelper(){
        emf = Persistence.createEntityManagerFactory("mohr");
        em = emf.createEntityManager();
    }

    public AnimalEarth getById(int id){
        em.getTransaction().begin();
        AnimalEarth animalEarth = em.find(AnimalEarth.class, id);
        em.getTransaction().commit();
        emf.close();
        return animalEarth;
    }

    public void add(AnimalEarth animalEarth){
        em.getTransaction().begin();
        em.merge(animalEarth);
        em.getTransaction().commit();
        emf.close();
    }

    public void  remove(AnimalEarth animalEarth){
        em.getTransaction().begin();
        em.remove(animalEarth);
        em.getTransaction().commit();
        emf.close();;
    }

    public List<AnimalEarth> getAll(){
        em.getTransaction().begin();
        Query query = em.createQuery("select animalearth from AnimalEarth animalearth");
        List<AnimalEarth> animalEarths = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return animalEarths;
    }
}
