package com.cl.dao;

import com.cl.entity.JiudianyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiudianyudingView;


/**
 * 酒店预定
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JiudianyudingDao extends BaseMapper<JiudianyudingEntity> {
	
	List<JiudianyudingView> selectListView(@Param("ew") Wrapper<JiudianyudingEntity> wrapper);

	List<JiudianyudingView> selectListView(Pagination page,@Param("ew") Wrapper<JiudianyudingEntity> wrapper);
	
	JiudianyudingView selectView(@Param("ew") Wrapper<JiudianyudingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianyudingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianyudingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianyudingEntity> wrapper);



}
