package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenqingdaoyouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingdaoyouView;


/**
 * 申请导游
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface ShenqingdaoyouService extends IService<ShenqingdaoyouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingdaoyouView> selectListView(Wrapper<ShenqingdaoyouEntity> wrapper);
   	
   	ShenqingdaoyouView selectView(@Param("ew") Wrapper<ShenqingdaoyouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingdaoyouEntity> wrapper);
   	

}

