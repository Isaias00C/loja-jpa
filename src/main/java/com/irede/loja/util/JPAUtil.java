package com.irede.loja.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    public static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("ormPU");

    private JPAUtil(){

    }

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
