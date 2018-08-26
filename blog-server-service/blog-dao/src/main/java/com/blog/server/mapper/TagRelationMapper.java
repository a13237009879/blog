package com.blog.servcer.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.blog.server.model.TagRelation;
import com.lzl.base.mapper.BaseMapper;
/**
 * 文章标签关系数据访问
 * @author admin
 *
 */
@Mapper
public interface TagRelationMapper extends BaseMapper<TagRelation, Integer> {


}
