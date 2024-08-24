package com.cl.dao;

import com.cl.entity.DiscussjiudianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiudianxinxiView;


/**
 * 酒店信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface DiscussjiudianxinxiDao extends BaseMapper<DiscussjiudianxinxiEntity> {
	
	List<DiscussjiudianxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiudianxinxiEntity> wrapper);

	List<DiscussjiudianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiudianxinxiEntity> wrapper);
	
	DiscussjiudianxinxiView selectView(@Param("ew") Wrapper<DiscussjiudianxinxiEntity> wrapper);
	

}
