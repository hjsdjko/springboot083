package com.cl.dao;

import com.cl.entity.RuzhushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RuzhushenqingView;


/**
 * 入住申请
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface RuzhushenqingDao extends BaseMapper<RuzhushenqingEntity> {
	
	List<RuzhushenqingView> selectListView(@Param("ew") Wrapper<RuzhushenqingEntity> wrapper);

	List<RuzhushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<RuzhushenqingEntity> wrapper);
	
	RuzhushenqingView selectView(@Param("ew") Wrapper<RuzhushenqingEntity> wrapper);
	

}
