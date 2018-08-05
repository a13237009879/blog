package com.lzl.base.biz.impl;

import java.util.List;

import org.apache.ibatis.executor.result.ResultMapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzl.base.biz.BaseBiz;
import com.lzl.base.mapper.BaseMapper;
import com.lzl.base.model.BaseModel;
import com.lzl.base.model.PageBean;
import com.lzl.base.model.PageCondition;
/**
 * 基础服务实现层
 * @author admin
 * @param <T>
 */
public abstract class BaseBizImpl<M extends BaseMapper<T,K>,T extends BaseModel<K>, K> implements BaseBiz<T, K>
{
	@Autowired
	protected M mapper;

	@Transactional
	public int deleteByPrimaryKey(K id) 
	{
		return mapper.deleteByPrimaryKey(id);
	}

	@Transactional
	public int insert(T record) 
	{
		return mapper.insert(record);
	}

	@Transactional
	public int insertSelective(T record) 
	{
		return mapper.insertSelective(record);
	}

	public T selectByPrimaryKey(K id) 
	{
		return mapper.selectByPrimaryKey(id);
	}

	@Transactional
	public int updateByPrimaryKeySelective(T record) 
	{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Transactional
	public int updateByPrimaryKey(T record) 
	{
		return mapper.updateByPrimaryKey(record);
	}

	public List<T> selectListByParam(T param) 
	{
		return mapper.selectListByParam(param);
	}
	
	@Transactional
	public int batchInsert(List<T> datas)
    {
		if (datas == null || datas.isEmpty())
		{
			throw new ResultMapException("批量查找的集合数量不能为空!");
		}
    	return mapper.batchInsert(datas);
    }
	
	public PageBean<T> findPage(PageCondition<T,K> condition)
	{
		PageHelper.startPage(condition.getCurPage(), condition.getPageSize());
		List<T> data = mapper.selectListByParam(condition.getSearchCondition());
		PageInfo<T> pageInfo = new PageInfo<>(data);
		return new PageBean<>(pageInfo);
	}
}
