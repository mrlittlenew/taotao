package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		//根据parentid查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo(1);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}
	@Override
	public TaotaoResult insertContentCategory(Long parentId, String name) {

		//创建一个pojo
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
	}
	@Override
	public TaotaoResult deteleContentCategory(Long id) {

		 TbContentCategory conCat = contentCategoryMapper.selectByPrimaryKey(id);

		//删除记录
		//'状态。可选值:1(正常),2(删除)',
		List<TbContentCategory> treeList = findContentCategoryTree(conCat.getId());
		treeList.add(conCat);
		for(TbContentCategory item:treeList){
			item.setStatus(2);
			contentCategoryMapper.updateByPrimaryKey(item);
		}
		
		
		
		 TbContentCategoryExample example=new TbContentCategoryExample();
		 Criteria criteria = example.createCriteria();
		 criteria.andParentIdEqualTo(conCat.getParentId());
		 criteria.andStatusEqualTo(1);
		 List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		 if(list==null||list.size()==0){
			//查看父节点的isParent列是否为true，如果是true改成false
			TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(conCat.getParentId());
			//判断是否为true
			if(parentCat.getIsParent()) {
				parentCat.setIsParent(false);
				//更新父节点
				contentCategoryMapper.updateByPrimaryKey(parentCat);
			}
		 }

		//返回结果
		return TaotaoResult.ok();
	}
	
	
	private List<TbContentCategory> findContentCategoryTree(Long arentId){
		TbContentCategoryExample example=new TbContentCategoryExample();	
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(arentId);
		criteria.andStatusEqualTo(1);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<TbContentCategory> subList=new ArrayList<TbContentCategory>();
		for(TbContentCategory item:list){
			subList = findContentCategoryTree(item.getId());
		}
		list.addAll(subList);
		return list;
	}
	
	@Override
	public TaotaoResult updateContentCategory(Long id, String name) {
		TbContentCategory conCat = contentCategoryMapper.selectByPrimaryKey(id);
		conCat.setName(name);
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		contentCategoryMapper.updateByExample(conCat, example);
		//返回结果
		return TaotaoResult.ok();
	}
	
}
