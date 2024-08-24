package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RuzhushenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RuzhushenqingView;


/**
 * 入住申请
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface RuzhushenqingService extends IService<RuzhushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RuzhushenqingView> selectListView(Wrapper<RuzhushenqingEntity> wrapper);
   	
   	RuzhushenqingView selectView(@Param("ew") Wrapper<RuzhushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RuzhushenqingEntity> wrapper);
   	

}

