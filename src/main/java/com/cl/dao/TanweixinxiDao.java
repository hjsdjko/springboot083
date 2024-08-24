package com.cl.dao;

import com.cl.entity.TanweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TanweixinxiView;


/**
 * 摊位信息
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface TanweixinxiDao extends BaseMapper<TanweixinxiEntity> {
	
	List<TanweixinxiView> selectListView(@Param("ew") Wrapper<TanweixinxiEntity> wrapper);

	List<TanweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TanweixinxiEntity> wrapper);
	
	TanweixinxiView selectView(@Param("ew") Wrapper<TanweixinxiEntity> wrapper);
	

}
