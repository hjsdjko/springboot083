package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MeishileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MeishileixingView;


/**
 * 美食类型
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface MeishileixingService extends IService<MeishileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishileixingView> selectListView(Wrapper<MeishileixingEntity> wrapper);
   	
   	MeishileixingView selectView(@Param("ew") Wrapper<MeishileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishileixingEntity> wrapper);
   	

}

