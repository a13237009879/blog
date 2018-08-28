package com.blog.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.blog.server.model.Article;
import com.lzl.base.mapper.BaseMapper;
/**
 * 文章数据访问mapper
 * @author admin
 *
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article, Integer>
{
	/**
	 * 通过ID集合加载文章信息
	 * @param ids
	 * @return
	 */
    public List<Article> queryArticleByIds(@Param("ids")List<String> ids);
}
