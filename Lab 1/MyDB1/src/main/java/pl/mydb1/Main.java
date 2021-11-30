/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mydb1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pawel
 */
public class Main {
    public static void main(String[] args) {
        Person3 person = new Person3();
        person.setName("John");
        Main main = new Main();
        main.persist(person);
    }
    
    
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl_MyDB1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
