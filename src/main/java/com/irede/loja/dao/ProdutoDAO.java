package com.irede.loja.dao;

import com.irede.loja.model.Produto;
import com.irede.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

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


}
