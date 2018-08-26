package com.lzl.base.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 基础实体类
 * @author admin
 *
 * @param <K> 主键类型
 */
public class BaseModel<K> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8940551756663629215L;

	/**
	 * 主键ID
	 */
	protected K id;
	
    /**
     * 创建人ID
     */
	protected Integer createUser;

	/**
	 * 修改人ID
	 */
	protected Integer updateUser;

	/**
	 * 创建时间
	 */
	protected Date createTime;

	/**
	 * 修改时间
	 */
	protected Date updateTime;
	
	/**
	 * 删除状态 0表示未删除 1表示删除
	 */
	protected Integer deleteFlag;

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
