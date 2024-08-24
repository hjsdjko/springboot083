package com.cl.dao;

import com.cl.entity.YiliaofuwuzhanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiliaofuwuzhanView;


/**
 * 医疗服务站
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface YiliaofuwuzhanDao extends BaseMapper<YiliaofuwuzhanEntity> {
	
	List<YiliaofuwuzhanView> selectListView(@Param("ew") Wrapper<YiliaofuwuzhanEntity> wrapper);

	List<YiliaofuwuzhanView> selectListView(Pagination page,@Param("ew") Wrapper<YiliaofuwuzhanEntity> wrapper);
	
	YiliaofuwuzhanView selectView(@Param("ew") Wrapper<YiliaofuwuzhanEntity> wrapper);
	

}
