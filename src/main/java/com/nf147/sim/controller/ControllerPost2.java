package com.nf147.sim.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.util.Map;

/*@Controller("/")*/
public class ControllerPost2 {

/*    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String getAll(@Param("name")String name, String a_name, Model model){
        model.addAttribute("name","name");
        model.addAttribute("a_name","a_name");
        System.out.println(a_name );
        System.out.println(name );
        return "listAll";
    }*/

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSource dataSource;

/*    @RequestMapping("/b")
    public void handleRequest(Model model){
        //applicationContext 它可以加载配置文件中定义的 bean，将所有的 bean 集中在一起，当有请求的时候分配 bean。
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(">>>"+ definitionName);
        }

        ApplicationContext parent = applicationContext.getParent();
        System.out.println(parent);
        for (String beanDefinitionName : parent.getBeanDefinitionNames()) {
            System.out.println("====="+ beanDefinitionName);
        }
    }*/

    @RequestMapping(value = "/a")
    public String handleRequest(Model model, ModelMap modelMap, Map map){
        model.addAttribute("aaa","aaa");
        modelMap.addAttribute("bbb","bbb");
        map.put("ccc","ccc");
        System.out.println(map);
        return "listAll";
    }

    @RequestMapping(value = "/xxx")
    public String xxx(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("a","aaa");
        redirectAttributes.addAttribute("b","bbb");
        //redirectAttributes.addFlashAttribute("c","ccc");
        //redirectAttributes.addFlashAttribute("d","ddd");

        return "redirect:/";
    }

}
