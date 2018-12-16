package com.nf147.sim.dao;

import com.nf147.sim.entity.Author;
import java.util.List;

public interface AuthorMapper {
    int deleteByPrimaryKey(Integer a_id);

    int insert(Author record);

    Author selectByPrimaryKey(Integer a_id);

    List<Author> selectAll();

    int updateByPrimaryKey(Author record);
}