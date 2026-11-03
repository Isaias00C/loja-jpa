package com.irede.loja;

import com.irede.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManager em =  JPAUtil.getEntityManager();
        em.close();
    }
}