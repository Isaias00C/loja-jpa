package com.irede.loja.dao;

import com.irede.loja.model.Produto;
import com.irede.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProdutoDAO {

    public Produto salvar(Produto produto){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(produto);
            tx.commit();
            return produto;
        }catch (RuntimeException e){
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }

    public Produto atualizar(Produto produto){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.merge(produto);
            tx.commit();
            return produto;
        }catch (RuntimeException e){
            e.printStackTrace();
            if(tx.isActive()){
                tx.rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }

    public Produto buscarPorId(Integer id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return em.find(Produto.class, id);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            em.close();
        }
    }

    public List<Produto> buscarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("select p from Produto p order by p.nome", Produto.class).getResultList();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            em.close();
        }
    }

}
