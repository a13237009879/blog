package com.blog.server.biz;

import java.util.List;

import com.blog.server.model.Tag;
import com.lzl.base.biz.BaseBiz;
/**
 * 文章标签业务逻辑类
 * @author admin
 *
 */
public interface TagBiz extends BaseBiz<Tag, Integer>{
	/**
	 * 批量保存文章标签与文章关联关系
	 * 如是新增的分类,则新增分类后在维护对应关系
	 * @param tags
	 */
    public void saveBatchTag(List<Tag> tags, Integer articleId);
    
    /**
     * 查询出标签值集合
     * @return 返回所有的标签值
     */
    public List<Tag> queryAllTag();
}
