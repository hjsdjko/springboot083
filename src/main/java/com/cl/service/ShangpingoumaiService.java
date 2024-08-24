package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShangpingoumaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShangpingoumaiView;


/**
 * 商品购买
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface ShangpingoumaiService extends IService<ShangpingoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpingoumaiView> selectListView(Wrapper<ShangpingoumaiEntity> wrapper);
   	
   	ShangpingoumaiView selectView(@Param("ew") Wrapper<ShangpingoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpingoumaiEntity> wrapper);
   	

}

