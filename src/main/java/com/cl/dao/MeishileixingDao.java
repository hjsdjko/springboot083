package com.cl.dao;

import com.cl.entity.MeishileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MeishileixingView;


/**
 * 美食类型
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface MeishileixingDao extends BaseMapper<MeishileixingEntity> {
	
	List<MeishileixingView> selectListView(@Param("ew") Wrapper<MeishileixingEntity> wrapper);

	List<MeishileixingView> selectListView(Pagination page,@Param("ew") Wrapper<MeishileixingEntity> wrapper);
	
	MeishileixingView selectView(@Param("ew") Wrapper<MeishileixingEntity> wrapper);
	

}
