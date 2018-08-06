package com.blog.server.biz.impl;

import org.springframework.stereotype.Service;

import com.blog.servcer.mapper.ReviewMapper;
import com.blog.server.biz.ReviewBiz;
import com.blog.server.model.Review;
import com.lzl.base.biz.impl.BaseBizImpl;
/**
 * 文章评论管理
 * @author admin
 *
 */
@Service
public class ReviewBizImpl extends BaseBizImpl<ReviewMapper,Review,Integer> implements ReviewBiz{

}
