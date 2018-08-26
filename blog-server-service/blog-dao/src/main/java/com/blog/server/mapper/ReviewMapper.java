package com.blog.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.blog.server.model.Review;
import com.lzl.base.mapper.BaseMapper;
/**
 * 评论数据访问
 * @author admin
 *
 */
@Mapper
public interface ReviewMapper extends BaseMapper<Review,Integer>{



}
