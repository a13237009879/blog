package com.blog.server.biz.impl;

import org.springframework.stereotype.Service;

import com.blog.server.biz.GuestBookBiz;
import com.blog.server.mapper.GuestBookMapper;
import com.blog.server.model.GuestBook;
import com.lzl.base.biz.impl.BaseBizImpl;
/**
 * 留言管理
 * @author admin
 *
 */
@Service
public class GuestBookBizImpl extends BaseBizImpl<GuestBookMapper,GuestBook, Integer> implements GuestBookBiz{

}
