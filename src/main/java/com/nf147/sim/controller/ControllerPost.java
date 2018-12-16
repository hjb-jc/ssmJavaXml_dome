package com.nf147.sim.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nf147.sim.dao.AuthorMapper;
import com.nf147.sim.dao.PostMapper;
import com.nf147.sim.entity.Author;
import com.nf147.sim.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class ControllerPost {
    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping
    public List<Author> selectAll() {
       return authorMapper.selectAll();
    }

/*

    @Autowired
    private PostMapper postMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String  select(@RequestParam(defaultValue = "1")int page , Model model){
        PageHelper.startPage(page,2);
        List<Author> authors = authorMapper.selectAll();
        model.addAttribute("authors",authors);
        model.addAttribute("pageInfo",new PageInfo<>(authors));
        return "listAll";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(Post post){
        postMapper.insert(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public String delete(@Param("p_id") int p_id){
        postMapper.deleteByPrimaryKey(p_id);
        return "redirect:/";
    }*/

}
