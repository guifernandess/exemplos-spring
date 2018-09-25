/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import br.senac.tads4.dsw.exemplosspring.model.Contador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@SessionAttributes("contador")
@RequestMapping("/sessao-contador1")
public class ExemploSessao1Controller {

    private Contador contador;

    @GetMapping("/{apelido}")
    public ModelAndView somar(@PathVariable("apelido") String nome) {
        contador.adicionar(nome);
        return new ModelAndView("sessao-contador");
    }

    @ModelAttribute("titulo")
    public String getTitulo() {
        return "Exemplo Sessao 1 - Uso do @SessionAttributes";
    }

    @ModelAttribute("contador")
    public Contador getContador() {
        if (contador == null) {
            contador = new Contador();
        }
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

}
