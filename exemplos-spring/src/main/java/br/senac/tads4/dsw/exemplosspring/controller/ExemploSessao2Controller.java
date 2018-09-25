/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import br.senac.tads4.dsw.exemplosspring.model.Contador;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@Scope("session")
@RequestMapping("/sessao-contador2")
public class ExemploSessao2Controller implements Serializable {

    private Map<String, Integer> dados = new LinkedHashMap<>();

    @GetMapping("/{apelido}")
    public ModelAndView somar(@PathVariable("apelido") String nome) {
        if (!dados.containsKey(nome)) {
            dados.put(nome, 0);
        }
        int valor = dados.get(nome);
        dados.put(nome, valor + 1);
        return new ModelAndView("sessao-contador2");
    }
    
    @ModelAttribute("titulo")
    public String getTitulo() {
        return "Exemplo Sessao 2 - Uso do @Controller + @Scope(\"session\")";
    }

    public Map<String, Integer> getDados() {
        return dados;
    }

    public void setDados(Map<String, Integer> dados) {
        this.dados = dados;
    }

}
