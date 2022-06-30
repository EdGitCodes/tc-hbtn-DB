package models;

import entities.Pessoa;
import entities.Produto;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa p) {
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

    public void update(Pessoa p, String nome, String email, Integer idade, String cpf, Date data) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        em.find(Produto.class , p.getId());

        try{
            em.getTransaction().begin();
            p.setNome(nome);
            p.setEmail(email);
            p.setIdade(idade);
            p.setCpf(cpf);
            p.setData_de_nascimento(data);
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        em.find(Produto.class, p.getId());
        try{
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Pessoa findById(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa pessoa = em.find(Pessoa.class, p.getId());
        System.out.println("Find good");
        return pessoa;
    }

    public List<Pessoa> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        List<Pessoa> pessoa = new ArrayList<Pessoa>();
        pessoa = em.createQuery("from Produto").getResultList();
        return pessoa;
    }
}