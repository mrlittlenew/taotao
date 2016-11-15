package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows,Long categoryId) {
		EUDataGridResult result = contentService.getContentList(page, rows,categoryId);
		return result;
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(Long ids) {
		TaotaoResult result = contentService.deleteContent(ids);
		return result;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult editContent(TbContent content) {
		TaotaoResult result = contentService.editContent(content);
		return result;
	}
	
	

}
