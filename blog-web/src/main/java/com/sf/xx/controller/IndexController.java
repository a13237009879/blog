package com.sf.xx.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.server.client.api.ArticleRpcClient;
import com.blog.server.client.dto.ResultMessageDto;
import com.blog.server.model.Article;
import com.reger.dubbo.annotation.Inject;

@Controller
@RequestMapping("/")
public class IndexController {

	private final static String indexView = "index";
	
	@Inject
    private ArticleRpcClient articleRpcClient;
	
	@RequestMapping("/index")
	public ModelAndView index()
	{
		ModelAndView view = new ModelAndView(indexView);
		ResultMessageDto<List<Article>> articleMsg = articleRpcClient.queryHotArticle(10);
		view.addObject("articles", articleMsg.getData());
		return view;
	}
}
