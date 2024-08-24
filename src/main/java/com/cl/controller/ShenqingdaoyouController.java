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

import com.cl.entity.ShenqingdaoyouEntity;
import com.cl.entity.view.ShenqingdaoyouView;

import com.cl.service.ShenqingdaoyouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请导游
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/shenqingdaoyou")
public class ShenqingdaoyouController {
    @Autowired
    private ShenqingdaoyouService shenqingdaoyouService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingdaoyouEntity shenqingdaoyou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shenqingdaoyou.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingdaoyouEntity> ew = new EntityWrapper<ShenqingdaoyouEntity>();

		PageUtils page = shenqingdaoyouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingdaoyou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingdaoyouEntity shenqingdaoyou, 
		HttpServletRequest request){
        EntityWrapper<ShenqingdaoyouEntity> ew = new EntityWrapper<ShenqingdaoyouEntity>();

		PageUtils page = shenqingdaoyouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingdaoyou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingdaoyouEntity shenqingdaoyou){
       	EntityWrapper<ShenqingdaoyouEntity> ew = new EntityWrapper<ShenqingdaoyouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingdaoyou, "shenqingdaoyou")); 
        return R.ok().put("data", shenqingdaoyouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingdaoyouEntity shenqingdaoyou){
        EntityWrapper< ShenqingdaoyouEntity> ew = new EntityWrapper< ShenqingdaoyouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingdaoyou, "shenqingdaoyou")); 
		ShenqingdaoyouView shenqingdaoyouView =  shenqingdaoyouService.selectView(ew);
		return R.ok("查询申请导游成功").put("data", shenqingdaoyouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingdaoyouEntity shenqingdaoyou = shenqingdaoyouService.selectById(id);
		shenqingdaoyou = shenqingdaoyouService.selectView(new EntityWrapper<ShenqingdaoyouEntity>().eq("id", id));
        return R.ok().put("data", shenqingdaoyou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingdaoyouEntity shenqingdaoyou = shenqingdaoyouService.selectById(id);
		shenqingdaoyou = shenqingdaoyouService.selectView(new EntityWrapper<ShenqingdaoyouEntity>().eq("id", id));
        return R.ok().put("data", shenqingdaoyou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增申请导游")
    public R save(@RequestBody ShenqingdaoyouEntity shenqingdaoyou, HttpServletRequest request){
    	shenqingdaoyou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingdaoyou);
        shenqingdaoyouService.insert(shenqingdaoyou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增申请导游")
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingdaoyouEntity shenqingdaoyou, HttpServletRequest request){
    	shenqingdaoyou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingdaoyou);
        shenqingdaoyouService.insert(shenqingdaoyou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改申请导游")
    public R update(@RequestBody ShenqingdaoyouEntity shenqingdaoyou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingdaoyou);
        shenqingdaoyouService.updateById(shenqingdaoyou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除申请导游")
    public R delete(@RequestBody Long[] ids){
        shenqingdaoyouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
