package com.lzl.base.utils;

import java.util.Date;

import com.lzl.base.model.BaseModel;

/**
 * model的基础属性初始化
 * @author admin
 *
 */
public class BasePropertiesInitail 
{
	/**
	 * 初始化basemodel的几个必填数据
	 * @param model
	 * @param userId
	 */
   public static <K>  void initBaseModel(BaseModel<K> model, Integer userId)
   {
	   if (model == null)
	   {
		   return;
	   }
	   Date curDate = new Date();
	   model.setCreateTime(curDate);
	   model.setUpdateTime(curDate);
	   model.setDeleteFlag(0);
	   model.setCreateUser(userId);
	   model.setUpdateUser(userId);
   }
}
