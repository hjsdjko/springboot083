package com.cl.dao;

import com.cl.entity.JiudianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiudianxinxiView;


/**
 * 酒店信息
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JiudianxinxiDao extends BaseMapper<JiudianxinxiEntity> {
	
	List<JiudianxinxiView> selectListView(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);

	List<JiudianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
	
	JiudianxinxiView selectView(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
	

}
