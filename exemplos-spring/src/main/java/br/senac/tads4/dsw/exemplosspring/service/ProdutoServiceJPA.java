/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.service;

import br.senac.tads4.dsw.exemplosspring.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guilherme.frocha6
 */

@Repository
public class ProdutoServiceJPA implements ProdutoService{
    
    @PersistenceContext
    private EntityManager entitymanager;
    
    @Override
    public List<Produto> findAll(int offset, int quantity) {
        Query queryJPQL = entitymanager.createQuery("SELECT p FROM Produto p");
        List<Produto> resultados = queryJPQL.getResultList();
        return resultados;
    }

    @Override
    public Produto findById(long idProduto) {
        Query queryJPQL = entitymanager.createQuery(
                "SELECT p FROM Produto p WHERE p.id = :idProd");
        queryJPQL.setParameter("idProd", idProduto);
        Produto resultado = (Produto) queryJPQL.getSingleResult();
        return resultado;
    }

    @Override
    public Produto save(Produto produto) {
        if (produto.getId() != null){
            //produto já existe -> ATUALIZA
            produto = entitymanager.merge(produto);
        } else {
            //produto não existe -> INSERE
            entitymanager.persist(produto);
        }
        return produto;
    }
    
    public void delete (long id) {
        Produto produto = entitymanager.find(Produto.class, id);
        entitymanager.remove(produto);
        
    }
    
    
}
