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


import com.cl.dao.ShangpingoumaiDao;
import com.cl.entity.ShangpingoumaiEntity;
import com.cl.service.ShangpingoumaiService;
import com.cl.entity.view.ShangpingoumaiView;

@Service("shangpingoumaiService")
public class ShangpingoumaiServiceImpl extends ServiceImpl<ShangpingoumaiDao, ShangpingoumaiEntity> implements ShangpingoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpingoumaiEntity> page = this.selectPage(
                new Query<ShangpingoumaiEntity>(params).getPage(),
                new EntityWrapper<ShangpingoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpingoumaiEntity> wrapper) {
		  Page<ShangpingoumaiView> page =new Query<ShangpingoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShangpingoumaiView> selectListView(Wrapper<ShangpingoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpingoumaiView selectView(Wrapper<ShangpingoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
