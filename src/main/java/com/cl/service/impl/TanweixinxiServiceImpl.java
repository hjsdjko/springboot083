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


import com.cl.dao.TanweixinxiDao;
import com.cl.entity.TanweixinxiEntity;
import com.cl.service.TanweixinxiService;
import com.cl.entity.view.TanweixinxiView;

@Service("tanweixinxiService")
public class TanweixinxiServiceImpl extends ServiceImpl<TanweixinxiDao, TanweixinxiEntity> implements TanweixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TanweixinxiEntity> page = this.selectPage(
                new Query<TanweixinxiEntity>(params).getPage(),
                new EntityWrapper<TanweixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TanweixinxiEntity> wrapper) {
		  Page<TanweixinxiView> page =new Query<TanweixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TanweixinxiView> selectListView(Wrapper<TanweixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TanweixinxiView selectView(Wrapper<TanweixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
