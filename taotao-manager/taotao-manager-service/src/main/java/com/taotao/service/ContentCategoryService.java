package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);

	TaotaoResult insertContentCategory(Long parentId, String name);

	TaotaoResult deteleContentCategory(Long id);

	TaotaoResult updateContentCategory(Long id, String name);

}
