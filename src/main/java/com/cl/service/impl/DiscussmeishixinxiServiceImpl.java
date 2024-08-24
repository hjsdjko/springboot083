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


import com.cl.dao.DiscussmeishixinxiDao;
import com.cl.entity.DiscussmeishixinxiEntity;
import com.cl.service.DiscussmeishixinxiService;
import com.cl.entity.view.DiscussmeishixinxiView;

@Service("discussmeishixinxiService")
public class DiscussmeishixinxiServiceImpl extends ServiceImpl<DiscussmeishixinxiDao, DiscussmeishixinxiEntity> implements DiscussmeishixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmeishixinxiEntity> page = this.selectPage(
                new Query<DiscussmeishixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussmeishixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmeishixinxiEntity> wrapper) {
		  Page<DiscussmeishixinxiView> page =new Query<DiscussmeishixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussmeishixinxiView> selectListView(Wrapper<DiscussmeishixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmeishixinxiView selectView(Wrapper<DiscussmeishixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
