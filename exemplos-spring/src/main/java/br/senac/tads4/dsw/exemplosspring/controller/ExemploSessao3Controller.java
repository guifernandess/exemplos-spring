/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/sessao-contador3")
public class ExemploSessao3Controller {

    @GetMapping("/{apelido}")
    public ModelAndView somar(@PathVariable("apelido") String nome, 
            HttpServletRequest request) {

        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("dados") == null) {
            sessao.setAttribute("dados", new LinkedHashMap<String, Integer>());
        }
        Map<String, Integer> dados = (Map<String, Integer>) sessao.getAttribute("dados");
        if (!dados.containsKey(nome)) {
            dados.put(nome, 0);
        }
        int valor = dados.get(nome);
        dados.put(nome, valor + 1);
        return new ModelAndView("sessao-contador")
                .addObject("dados", dados);
    }

    @ModelAttribute("titulo")
    public String getTitulo() {
        return "Exemplo Sessao 2 - Uso do @Controller + @Scope(\"session\")";
    }
}
