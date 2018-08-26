package com.blog.server.biz.impl;

import org.springframework.stereotype.Service;

import com.blog.server.biz.BlogUserBiz;
import com.blog.server.mapper.BlogUserMapper;
import com.blog.server.model.BlogUser;
import com.lzl.base.biz.impl.BaseBizImpl;
/**
 * 博客用户管理
 * @author admin
 *
 */
@Service
public class BlogUserBizImpl extends BaseBizImpl<BlogUserMapper,BlogUser, Integer> implements BlogUserBiz{

}
