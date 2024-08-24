package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YiliaofuwuzhanDao;
import com.cl.entity.YiliaofuwuzhanEntity;
import com.cl.service.YiliaofuwuzhanService;
import com.cl.entity.view.YiliaofuwuzhanView;

@Service("yiliaofuwuzhanService")
public class YiliaofuwuzhanServiceImpl extends ServiceImpl<YiliaofuwuzhanDao, YiliaofuwuzhanEntity> implements YiliaofuwuzhanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiliaofuwuzhanEntity> page = this.selectPage(
                new Query<YiliaofuwuzhanEntity>(params).getPage(),
                new EntityWrapper<YiliaofuwuzhanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiliaofuwuzhanEntity> wrapper) {
		  Page<YiliaofuwuzhanView> page =new Query<YiliaofuwuzhanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YiliaofuwuzhanView> selectListView(Wrapper<YiliaofuwuzhanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiliaofuwuzhanView selectView(Wrapper<YiliaofuwuzhanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
