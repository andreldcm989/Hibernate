package br.com.projetojpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.projetojpa.model.Categoria;

public class App {
    public static void main(String[] args) {

        Set<Categoria> categorias = new HashSet<>();
        Categoria c1 = new Categoria("Padaria");
        Categoria c2 = new Categoria("Mercado");
        Categoria c3 = new Categoria("Transporte");
        // Categoria c4 = new Categoria("Lazer");
        categorias.addAll(Arrays.asList(c1, c2, c3));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("financeiro");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        categorias.forEach(c -> {
            em.persist(c);
        });
        em.getTransaction().commit();
        List<Categoria> lista = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        lista.forEach(System.out::println);
        em.close();

        System.out.println("--------------------------------------");

        EntityManager em2 = factory.createEntityManager();
        Categoria cat = em2.merge(c2);
        System.out.println(cat);

        em2.getTransaction().begin();
        cat.setNome("Sacolão");
        em2.flush();
        List<Categoria> lista2 = em2.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        lista2.forEach(System.out::println);
        em2.close();
    }
}
