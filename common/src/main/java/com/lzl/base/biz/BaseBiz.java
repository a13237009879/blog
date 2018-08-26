package com.lzl.base.biz;

import java.util.List;

import com.lzl.base.model.BaseModel;
import com.lzl.base.model.PageBean;
import com.lzl.base.model.PageCondition;


/**
 * 基础服务层
 * @author admin
 *
 * @param <T>
 */
public interface BaseBiz <T extends BaseModel<K>, K>
{

	/**
	 * 删除一条数据,通过主键id
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(K id);

	/**
	 * 插入一条数据
	 * @param record
	 * @return
	 */
    int insert(T record);

    /**
     * 只插入不为空的列数据
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 通过主键查询数据
     * @param id
     * @return
     */
    T selectByPrimaryKey(K id);

    /**
     * 通过ID更新动态数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新所有的数据行
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);
    
    /**
     * 根据当前条件查询数据
     * @param param
     * @return
     */
    List<T> selectListByParam(T param);
    
    /**
     * 批量更新数据
     * @param datas
     * @return
     */
    int batchInsert(List<T> datas);
    
    /**
     * 分页查找数据
     * @return
     */
    PageBean<T> findPage(PageCondition<T,K> condition);
}
