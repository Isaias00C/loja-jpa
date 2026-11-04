package com.irede.loja;

import com.irede.loja.dao.ProdutoDAO;
import com.irede.loja.model.Produto;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        try{
            Produto caneta = new Produto("caneta", "CNTAZL", new BigDecimal("1.99"));
            dao.salvar(caneta);

            caneta.setDescricao("essa é uma caneta azul");
            dao.atualizar(caneta);

            Produto mouse = new Produto("mouse", "MSE", new BigDecimal("159.99"));
            dao.salvar(mouse);

            List<Produto> produtos = dao.buscarTodos();

            for(Produto p : produtos){
                System.out.println("-> " + p);
            }

            dao.deletar(caneta.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}