package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TanweixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TanweixinxiView;


/**
 * 摊位信息
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface TanweixinxiService extends IService<TanweixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TanweixinxiView> selectListView(Wrapper<TanweixinxiEntity> wrapper);
   	
   	TanweixinxiView selectView(@Param("ew") Wrapper<TanweixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TanweixinxiEntity> wrapper);
   	

}

