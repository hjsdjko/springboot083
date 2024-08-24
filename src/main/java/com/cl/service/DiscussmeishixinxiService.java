package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussmeishixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussmeishixinxiView;


/**
 * 美食信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface DiscussmeishixinxiService extends IService<DiscussmeishixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishixinxiView> selectListView(Wrapper<DiscussmeishixinxiEntity> wrapper);
   	
   	DiscussmeishixinxiView selectView(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishixinxiEntity> wrapper);
   	

}

