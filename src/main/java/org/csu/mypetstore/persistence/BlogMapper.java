package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    List<Blog> getBlogByUsername(String username);

    void insertBlog(Blog blog);
}
