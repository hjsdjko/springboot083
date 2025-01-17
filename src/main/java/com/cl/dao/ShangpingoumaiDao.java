package com.cl.dao;

import com.cl.entity.ShangpingoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShangpingoumaiView;


/**
 * 商品购买
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface ShangpingoumaiDao extends BaseMapper<ShangpingoumaiEntity> {
	
	List<ShangpingoumaiView> selectListView(@Param("ew") Wrapper<ShangpingoumaiEntity> wrapper);

	List<ShangpingoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpingoumaiEntity> wrapper);
	
	ShangpingoumaiView selectView(@Param("ew") Wrapper<ShangpingoumaiEntity> wrapper);
	

}
