/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/layout-dialect")
public class LayoutDialectController {
    
    @GetMapping("/tela01")
    public ModelAndView tela1() {
        return new ModelAndView("layout-dialect01");
    }
    
    @GetMapping("/tela02")
    public ModelAndView tela2() {
        return new ModelAndView("layout-dialect02");
    }
    
    @GetMapping("/tela03")
    public ModelAndView tela3(@RequestParam(name = "id", required = false) Integer idSelecionado) {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        
        return new ModelAndView("layout-dialect03")
                .addObject("ids", ids)
                .addObject("idSelecionado", idSelecionado);
    }
}
