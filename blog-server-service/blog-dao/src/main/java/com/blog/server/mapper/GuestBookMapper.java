package com.blog.server.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blog.server.model.GuestBook;
import com.lzl.base.mapper.BaseMapper;
/**
 * 留言数据访问
 * @author admin
 *
 */
@Mapper
public interface GuestBookMapper extends BaseMapper<GuestBook,Integer>{


}
