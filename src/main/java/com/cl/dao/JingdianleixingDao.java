package com.cl.dao;

import com.cl.entity.JingdianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianleixingView;


/**
 * 景点类型
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JingdianleixingDao extends BaseMapper<JingdianleixingEntity> {
	
	List<JingdianleixingView> selectListView(@Param("ew") Wrapper<JingdianleixingEntity> wrapper);

	List<JingdianleixingView> selectListView(Pagination page,@Param("ew") Wrapper<JingdianleixingEntity> wrapper);
	
	JingdianleixingView selectView(@Param("ew") Wrapper<JingdianleixingEntity> wrapper);
	

}
