package models;

import controller.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdModel {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpPU");
        return factory.createEntityManager();

    }

    public Produto salvar(Produto p) throws Exception {
        EntityManager emy = getEM();
        try {
            //Abrindo uma transação com a base de dados
            emy.getTransaction().begin();
            if (p.getId() == null) {
                emy.persist(p); //Preparando um INSERT
            } else {
                emy.merge(p); //Preparando um UPDATE
            }
            emy.getTransaction().commit(); //Injetando o SQL
        } catch (Exception e) {
            emy.getTransaction().rollback();
        } finally {
            emy.close();
        }
        return p;
    }

    public List<Produto> listarOrdemNome() {
        EntityManager em = getEM();
        try {
            List produto = em.createQuery("select p from Produto p order by p.Nome").getResultList();
            return produto;
        } finally {
            em.close();
        }
    }

    public Produto listaUnicaProd(Long id) {
        EntityManager em = getEM();
        try {
            Produto p = (Produto) em.createQuery("select p from Produto p where p.id = " + id).getSingleResult();
            return p;

        } finally {
            em.close();
        }

    }

    public void remover(long id) throws Exception {
        EntityManager em = getEM();
        Produto p = em.find(Produto.class, id);
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
