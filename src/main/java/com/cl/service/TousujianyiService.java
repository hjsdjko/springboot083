package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TousujianyiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TousujianyiView;


/**
 * 投诉建议
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface TousujianyiService extends IService<TousujianyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TousujianyiView> selectListView(Wrapper<TousujianyiEntity> wrapper);
   	
   	TousujianyiView selectView(@Param("ew") Wrapper<TousujianyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TousujianyiEntity> wrapper);
   	

}

