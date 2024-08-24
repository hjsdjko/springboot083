package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiudianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiudianxinxiView;


/**
 * 酒店信息
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
public interface JiudianxinxiService extends IService<JiudianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiudianxinxiView> selectListView(Wrapper<JiudianxinxiEntity> wrapper);
   	
   	JiudianxinxiView selectView(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiudianxinxiEntity> wrapper);
   	

}

