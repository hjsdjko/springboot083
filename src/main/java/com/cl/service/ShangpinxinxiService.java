package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShangpinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShangpinxinxiView;


/**
 * 商品信息
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface ShangpinxinxiService extends IService<ShangpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpinxinxiView> selectListView(Wrapper<ShangpinxinxiEntity> wrapper);
   	
   	ShangpinxinxiView selectView(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShangpinxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShangpinxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShangpinxinxiEntity> wrapper);



}
