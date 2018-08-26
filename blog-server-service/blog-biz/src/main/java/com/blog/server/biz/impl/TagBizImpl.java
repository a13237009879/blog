package com.blog.server.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.server.biz.TagBiz;
import com.blog.server.mapper.TagMapper;
import com.blog.server.mapper.TagRelationMapper;
import com.blog.server.model.Tag;
import com.blog.server.model.TagRelation;
import com.lzl.base.biz.impl.BaseBizImpl;
import com.lzl.base.utils.BasePropertiesInitail;
/**
 * 文章标签管理
 * @author admin
 *
 */
@Service
public class TagBizImpl extends BaseBizImpl<TagMapper, Tag,Integer> implements TagBiz{

	@Autowired
	private TagRelationMapper tagRelationMapper;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveBatchTag(List<Tag> tags, Integer articleId) 
	{
		if (tags == null || tags.isEmpty())
		{
			return;
		}
		if (articleId == null)
		{
			return;
		}
		List<TagRelation> relations = new ArrayList<TagRelation>();
		TagRelation relation = null;
		for (Tag tag : tags) 
		{
			if (tag.getId() == null)
			{
				BasePropertiesInitail.initBaseModel(tag, null);
				mapper.insert(tag);
			}
			relation = new TagRelation();
			BasePropertiesInitail.initBaseModel(relation, null);
			relation.setArticleId(articleId);
			relation.setTagId(tag.getId());
		}
		if (relations != null)
		{
			tagRelationMapper.batchInsert(relations);
		}
	}

	@Override
	public List<Tag> queryAllTag() 
	{
		return mapper.selectListByParam(new Tag());
	}

}
