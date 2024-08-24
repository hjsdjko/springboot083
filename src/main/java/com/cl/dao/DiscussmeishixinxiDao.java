package com.cl.dao;

import com.cl.entity.DiscussmeishixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussmeishixinxiView;


/**
 * 美食信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface DiscussmeishixinxiDao extends BaseMapper<DiscussmeishixinxiEntity> {
	
	List<DiscussmeishixinxiView> selectListView(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);

	List<DiscussmeishixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
	
	DiscussmeishixinxiView selectView(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
	

}
