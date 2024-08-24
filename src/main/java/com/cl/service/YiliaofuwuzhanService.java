package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YiliaofuwuzhanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiliaofuwuzhanView;


/**
 * 医疗服务站
 *
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
public interface YiliaofuwuzhanService extends IService<YiliaofuwuzhanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiliaofuwuzhanView> selectListView(Wrapper<YiliaofuwuzhanEntity> wrapper);
   	
   	YiliaofuwuzhanView selectView(@Param("ew") Wrapper<YiliaofuwuzhanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiliaofuwuzhanEntity> wrapper);
   	

}

