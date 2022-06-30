package models;

import entities.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p, String nome, Integer quantidade, double preco, boolean status) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        em.find(Produto.class , p.getId());

        try{
            em.getTransaction().begin();
            p.setNome(nome);
            p.setPreco(preco);
            p.setQuantidade(quantidade);
            p.setStatus(status);
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Update good");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto prod = em.find(Produto.class, p.getId());
        try{
            em.getTransaction().begin();
            em.remove(prod);
            em.getTransaction().commit();
            System.out.println("Delete good");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Produto findById(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Produto prod = em.find(Produto.class, p.getId());
        System.out.println("Find good");
        return prod;
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        List<Produto> produtos = new ArrayList<Produto>();
        produtos = em.createQuery("from Produto").getResultList();
        return produtos;
    }
}