package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Blog;
import org.csu.mypetstore.persistence.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    //日志记录
    @Autowired
    private BlogMapper blogMapper;

    //查询日志
    public List<Blog> getBlogByUsername(String username){
        System.out.println(username + blogMapper.getBlogByUsername(username).size());
        return blogMapper.getBlogByUsername(username);
    }

    //插入日志
    public void insertBlog(Blog blog){
        blogMapper.insertBlog(blog);
    }
}
