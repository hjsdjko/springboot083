package com.cl.dao;

import com.cl.entity.JiudianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiudianleixingView;


/**
 * 酒店类型
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JiudianleixingDao extends BaseMapper<JiudianleixingEntity> {
	
	List<JiudianleixingView> selectListView(@Param("ew") Wrapper<JiudianleixingEntity> wrapper);

	List<JiudianleixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiudianleixingEntity> wrapper);
	
	JiudianleixingView selectView(@Param("ew") Wrapper<JiudianleixingEntity> wrapper);
	

}
