package com.blog.server.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blog.server.model.Content;
import com.lzl.base.mapper.BaseMapper;
/**
 * 文章内容数据访问
 * @author admin
 *
 */
@Mapper
public interface ContentMapper extends BaseMapper<Content, Integer>
{

}