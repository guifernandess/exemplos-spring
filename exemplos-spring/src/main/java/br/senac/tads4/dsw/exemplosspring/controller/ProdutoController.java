/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import br.senac.tads4.dsw.exemplosspring.service.ProdutoService;
import br.senac.tads4.dsw.exemplosspring.service.ProdutoServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.senac.tads4.dsw.exemplosspring.model.Produto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author guilherme.frocha6
 */

@Controller
@RequestMapping("/produto")

public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;/// = new ProdutoServiceJPA();
    
    public ModelAndView listar() {
        List<Produto> produtos = produtoService.findAll(0, 100);
        return new ModelAndView("produto/lista")
                .addObject("produto", produtos);
    }
    
    @GetMapping("/novo")
    public ModelAndView IncluirNovo() {
        return new ModelAndView("produto/formulario")
                .addObject("produto", new Produto());
    }
    
    @GetMapping("/{id}/editar")//editar
    public ModelAndView editar(@PathVariable("id") Long id) {
        
        Produto produto = produtoService.findById(id);
        return new ModelAndView("produto/formulario")
                .addObject("produto", produto);
    }
   /*
    @GetMapping("/salvar")
     public ModelAndView salvar (Produto produto) {
     */
}
