package com.cl.dao;

import com.cl.entity.MenpiaogoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenpiaogoumaiView;


/**
 * 门票购买
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface MenpiaogoumaiDao extends BaseMapper<MenpiaogoumaiEntity> {
	
	List<MenpiaogoumaiView> selectListView(@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);

	List<MenpiaogoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);
	
	MenpiaogoumaiView selectView(@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);



}
