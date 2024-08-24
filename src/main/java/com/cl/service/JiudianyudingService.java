package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiudianyudingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiudianyudingView;


/**
 * 酒店预定
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JiudianyudingService extends IService<JiudianyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiudianyudingView> selectListView(Wrapper<JiudianyudingEntity> wrapper);
   	
   	JiudianyudingView selectView(@Param("ew") Wrapper<JiudianyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiudianyudingEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiudianyudingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiudianyudingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiudianyudingEntity> wrapper);



}

