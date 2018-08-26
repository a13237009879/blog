package com.blog.server.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blog.server.model.BlogUser;
import com.lzl.base.mapper.BaseMapper;
/**
 * 博客数据访问
 * @author admin
 *
 */
@Mapper
public interface BlogUserMapper extends BaseMapper<BlogUser, Integer>
{

}
