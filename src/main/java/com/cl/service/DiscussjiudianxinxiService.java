package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjiudianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiudianxinxiView;


/**
 * 酒店信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface DiscussjiudianxinxiService extends IService<DiscussjiudianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiudianxinxiView> selectListView(Wrapper<DiscussjiudianxinxiEntity> wrapper);
   	
   	DiscussjiudianxinxiView selectView(@Param("ew") Wrapper<DiscussjiudianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiudianxinxiEntity> wrapper);
   	

}

