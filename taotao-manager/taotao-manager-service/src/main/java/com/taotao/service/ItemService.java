package com.taotao.service;


import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

public interface ItemService {

	TbItem getItemById(long itemId);

	EUDataGridResult getItemList(int page, int rows);

	TaotaoResult addItem(TbItem item, TbItemDesc itemDesc);

	TaotaoResult createItem(TbItem item, String desc,String itemParam) throws Exception;
	
}
