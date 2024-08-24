package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.TanweixinxiEntity;
import com.cl.entity.view.TanweixinxiView;

import com.cl.service.TanweixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 摊位信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/tanweixinxi")
public class TanweixinxiController {
    @Autowired
    private TanweixinxiService tanweixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TanweixinxiEntity tanweixinxi,
		HttpServletRequest request){
        EntityWrapper<TanweixinxiEntity> ew = new EntityWrapper<TanweixinxiEntity>();

		PageUtils page = tanweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tanweixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TanweixinxiEntity tanweixinxi, 
		HttpServletRequest request){
        EntityWrapper<TanweixinxiEntity> ew = new EntityWrapper<TanweixinxiEntity>();

		PageUtils page = tanweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tanweixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TanweixinxiEntity tanweixinxi){
       	EntityWrapper<TanweixinxiEntity> ew = new EntityWrapper<TanweixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tanweixinxi, "tanweixinxi")); 
        return R.ok().put("data", tanweixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TanweixinxiEntity tanweixinxi){
        EntityWrapper< TanweixinxiEntity> ew = new EntityWrapper< TanweixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tanweixinxi, "tanweixinxi")); 
		TanweixinxiView tanweixinxiView =  tanweixinxiService.selectView(ew);
		return R.ok("查询摊位信息成功").put("data", tanweixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TanweixinxiEntity tanweixinxi = tanweixinxiService.selectById(id);
		tanweixinxi = tanweixinxiService.selectView(new EntityWrapper<TanweixinxiEntity>().eq("id", id));
        return R.ok().put("data", tanweixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TanweixinxiEntity tanweixinxi = tanweixinxiService.selectById(id);
		tanweixinxi = tanweixinxiService.selectView(new EntityWrapper<TanweixinxiEntity>().eq("id", id));
        return R.ok().put("data", tanweixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增摊位信息")
    public R save(@RequestBody TanweixinxiEntity tanweixinxi, HttpServletRequest request){
    	tanweixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tanweixinxi);
        tanweixinxiService.insert(tanweixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增摊位信息")
    @RequestMapping("/add")
    public R add(@RequestBody TanweixinxiEntity tanweixinxi, HttpServletRequest request){
    	tanweixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tanweixinxi);
        tanweixinxiService.insert(tanweixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改摊位信息")
    public R update(@RequestBody TanweixinxiEntity tanweixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tanweixinxi);
        tanweixinxiService.updateById(tanweixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除摊位信息")
    public R delete(@RequestBody Long[] ids){
        tanweixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
