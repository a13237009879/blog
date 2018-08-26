package com.lzl.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 基础mapper
 * @author admin
 *
 */
public interface BaseMapper <T,K>
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
    int batchInsert(@Param("datas")List<T> datas);
}
