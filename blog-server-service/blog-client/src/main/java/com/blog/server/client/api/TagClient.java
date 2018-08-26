package com.blog.server.client.api;

import java.util.List;

import com.blog.server.client.dto.ResultMessageDto;
import com.blog.server.model.Tag;
import com.lzl.base.model.PageBean;

/**
 * 文章标签客户端
 * @author admin
 *
 */
public interface TagClient {

	/**
	 * 获取当前比较活跃的标签进行展现
	 * @return
	 */
	public ResultMessageDto<List<Tag>> queryHotTag();
	/**
	 * 保存或者修改标签
	 * @param tag
	 * @return
	 */
	public ResultMessageDto<Boolean> saveOrUpdateTag(Tag tag);
 	
	/**
 	 * 分页查找
 	 * @return
 	 */
	public ResultMessageDto<PageBean<Tag>> queryTagPage();
	
	public ResultMessageDto<Boolean> deleteTag(String tagId);
}
