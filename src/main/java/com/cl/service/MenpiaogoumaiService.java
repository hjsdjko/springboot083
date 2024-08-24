package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MenpiaogoumaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenpiaogoumaiView;


/**
 * 门票购买
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface MenpiaogoumaiService extends IService<MenpiaogoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenpiaogoumaiView> selectListView(Wrapper<MenpiaogoumaiEntity> wrapper);
   	
   	MenpiaogoumaiView selectView(@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenpiaogoumaiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<MenpiaogoumaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<MenpiaogoumaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<MenpiaogoumaiEntity> wrapper);



}

