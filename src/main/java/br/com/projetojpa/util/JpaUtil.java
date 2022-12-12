package br.com.projetojpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface JpaUtil {

    default EntityManager getEntityManager(String db) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(db);
        return factory.createEntityManager();
    }

}
