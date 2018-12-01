package models;

import controller.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FunModel {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpPU");
        return factory.createEntityManager();
    }

    public Funcionario salvar(Funcionario f) throws Exception {
        EntityManager em = getEM();
        try {
            //Abrindo uma transação com a base de dados
            em.getTransaction().begin();
            if (f.getId() == null) {
                em.persist(f); //Preparando um INSERT
            } else {
                em.merge(f); //Preparando um UPDATE
            }
            em.getTransaction().commit(); //Injetando o SQL
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return f;
    }

    public List<Funcionario> listarOrdemNomes() {
        EntityManager em = getEM();
        try {
            List funcionario = em.createQuery("select f from Funcionario f order by f.nome").getResultList();
            return funcionario;
        } finally {
            em.close();
        }
    }

    public Funcionario listaUnicoFun(Long id){
        EntityManager em = getEM();
        try {
            Funcionario f = (Funcionario) em.createQuery("select f from Funcionario f where f.id = " +id).getSingleResult();
                    return f;
            
        } finally {
            em.close();
        }
    }
    public void remover(long id) throws Exception {
        EntityManager em = getEM();
        Funcionario f = em.find(Funcionario.class, id);
        try {
            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
