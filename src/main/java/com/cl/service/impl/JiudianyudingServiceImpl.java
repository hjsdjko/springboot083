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


import com.cl.dao.JiudianyudingDao;
import com.cl.entity.JiudianyudingEntity;
import com.cl.service.JiudianyudingService;
import com.cl.entity.view.JiudianyudingView;

@Service("jiudianyudingService")
public class JiudianyudingServiceImpl extends ServiceImpl<JiudianyudingDao, JiudianyudingEntity> implements JiudianyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiudianyudingEntity> page = this.selectPage(
                new Query<JiudianyudingEntity>(params).getPage(),
                new EntityWrapper<JiudianyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiudianyudingEntity> wrapper) {
		  Page<JiudianyudingView> page =new Query<JiudianyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiudianyudingView> selectListView(Wrapper<JiudianyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiudianyudingView selectView(Wrapper<JiudianyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiudianyudingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiudianyudingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiudianyudingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
