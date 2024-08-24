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


import com.cl.dao.MeishixinxiDao;
import com.cl.entity.MeishixinxiEntity;
import com.cl.service.MeishixinxiService;
import com.cl.entity.view.MeishixinxiView;

@Service("meishixinxiService")
public class MeishixinxiServiceImpl extends ServiceImpl<MeishixinxiDao, MeishixinxiEntity> implements MeishixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishixinxiEntity> page = this.selectPage(
                new Query<MeishixinxiEntity>(params).getPage(),
                new EntityWrapper<MeishixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishixinxiEntity> wrapper) {
		  Page<MeishixinxiView> page =new Query<MeishixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MeishixinxiView> selectListView(Wrapper<MeishixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishixinxiView selectView(Wrapper<MeishixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
