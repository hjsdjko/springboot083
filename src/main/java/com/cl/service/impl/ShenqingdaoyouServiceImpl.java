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


import com.cl.dao.ShenqingdaoyouDao;
import com.cl.entity.ShenqingdaoyouEntity;
import com.cl.service.ShenqingdaoyouService;
import com.cl.entity.view.ShenqingdaoyouView;

@Service("shenqingdaoyouService")
public class ShenqingdaoyouServiceImpl extends ServiceImpl<ShenqingdaoyouDao, ShenqingdaoyouEntity> implements ShenqingdaoyouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingdaoyouEntity> page = this.selectPage(
                new Query<ShenqingdaoyouEntity>(params).getPage(),
                new EntityWrapper<ShenqingdaoyouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingdaoyouEntity> wrapper) {
		  Page<ShenqingdaoyouView> page =new Query<ShenqingdaoyouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShenqingdaoyouView> selectListView(Wrapper<ShenqingdaoyouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingdaoyouView selectView(Wrapper<ShenqingdaoyouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
