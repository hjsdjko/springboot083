package com.cl.dao;

import com.cl.entity.ShenqingdaoyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingdaoyouView;


/**
 * 申请导游
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface ShenqingdaoyouDao extends BaseMapper<ShenqingdaoyouEntity> {
	
	List<ShenqingdaoyouView> selectListView(@Param("ew") Wrapper<ShenqingdaoyouEntity> wrapper);

	List<ShenqingdaoyouView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingdaoyouEntity> wrapper);
	
	ShenqingdaoyouView selectView(@Param("ew") Wrapper<ShenqingdaoyouEntity> wrapper);
	

}
