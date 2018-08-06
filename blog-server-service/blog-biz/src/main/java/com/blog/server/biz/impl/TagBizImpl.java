package com.blog.server.biz.impl;

import org.springframework.stereotype.Service;

import com.blog.servcer.mapper.TagMapper;
import com.blog.server.biz.TagBiz;
import com.blog.server.model.Tag;
import com.lzl.base.biz.impl.BaseBizImpl;
/**
 * 文章标签管理
 * @author admin
 *
 */
@Service
public class TagBizImpl extends BaseBizImpl<TagMapper, Tag,Integer> implements TagBiz{

}
