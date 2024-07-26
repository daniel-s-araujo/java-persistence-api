package br.com.devmedia.introducaojpa.aplicacao;

import br.com.devmedia.introducaojpa.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Programa {

    public static void main(String args[]) {
        Pessoa pessoa1 = new Pessoa("Eduardo", 33);
        Pessoa pessoa2 = new Pessoa("Gustavo", 34);

        EntityManager em = Persistence.createEntityManagerFactory("introducao-jpa").createEntityManager();

        System.out.println("Persistindo duas pessoas no banco de dados:");
        em.getTransaction().begin();
        em.persist(pessoa1);
        em.persist(pessoa2);
        em.getTransaction().commit();

        System.out.println("Recuperando as pessoas cadastradas do banco de dados:");
        List<Pessoa> pessoas = em.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
        System.out.println(pessoas);
        em.close();
    }

}
