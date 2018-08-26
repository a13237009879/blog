package com.blog.server.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blog.server.model.Tag;
import com.lzl.base.mapper.BaseMapper;

/**
 * 文章分类数据访问
 * @author admin
 *
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag,Integer>
{


}
