package br.com.projetojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist("teste");
        em.getTransaction().commit();
        em.close();

    }
}
