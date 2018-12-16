package com.dao;


import com.nf147.sim.dao.AuthorMapper;
import com.nf147.sim.dao.PostMapper;
import com.nf147.sim.entity.Author;
import com.nf147.sim.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sun.net.www.protocol.http.AuthCache;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring/app-dao.xml")
public class App {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void test(){
        List<Post> posts = postMapper.selectAll();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

}
