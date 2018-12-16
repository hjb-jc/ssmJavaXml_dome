package com.nf147.sim.dao;

import com.nf147.sim.entity.Post;
import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer p_id);

    int insert(Post record);

    Post selectByPrimaryKey(Integer p_id);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);
}