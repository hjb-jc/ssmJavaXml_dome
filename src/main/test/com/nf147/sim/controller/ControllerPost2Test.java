package com.nf147.sim.controller;

import com.nf147.sim.dao.AuthorMapper;
import com.nf147.sim.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring/app-dao.xml")
public class ControllerPost2Test {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void test(){
        List<Author> authors = authorMapper.selectAll();
        authors.forEach(System.out::println);
    }
    
    @Test
    public void url() throws IOException {
        ClassLoader cl = Author.class.getClassLoader();
        Thread.currentThread().getContextClassLoader();
        URL resource = Author.class.getClassLoader().getResource("generatorConfig.xml");
        System.out.println(resource);

        InputStream resourceAsStream = cl.getResourceAsStream("logback.xml");
        URL resource1 = cl.getResource("logback.xml");
        System.out.println(resource1);

        InputStream resourceAsStream1 = cl.getResourceAsStream("mybatis-config.xml");
        Enumeration<URL> resources = cl.getResources("mybatis-config.xml");
        while (resources.hasMoreElements()) System.out.println(resources.nextElement());

    }

}