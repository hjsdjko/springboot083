package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiudianleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiudianleixingView;


/**
 * 酒店类型
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JiudianleixingService extends IService<JiudianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiudianleixingView> selectListView(Wrapper<JiudianleixingEntity> wrapper);
   	
   	JiudianleixingView selectView(@Param("ew") Wrapper<JiudianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiudianleixingEntity> wrapper);
   	

}

