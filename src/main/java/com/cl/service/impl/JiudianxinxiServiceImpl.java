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


import com.cl.dao.JiudianxinxiDao;
import com.cl.entity.JiudianxinxiEntity;
import com.cl.service.JiudianxinxiService;
import com.cl.entity.view.JiudianxinxiView;

@Service("jiudianxinxiService")
public class JiudianxinxiServiceImpl extends ServiceImpl<JiudianxinxiDao, JiudianxinxiEntity> implements JiudianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiudianxinxiEntity> page = this.selectPage(
                new Query<JiudianxinxiEntity>(params).getPage(),
                new EntityWrapper<JiudianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiudianxinxiEntity> wrapper) {
		  Page<JiudianxinxiView> page =new Query<JiudianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiudianxinxiView> selectListView(Wrapper<JiudianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiudianxinxiView selectView(Wrapper<JiudianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
