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

import com.cl.entity.JingdianleixingEntity;
import com.cl.entity.view.JingdianleixingView;

import com.cl.service.JingdianleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 景点类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@RestController
@RequestMapping("/jingdianleixing")
public class JingdianleixingController {
    @Autowired
    private JingdianleixingService jingdianleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianleixingEntity jingdianleixing,
		HttpServletRequest request){
        EntityWrapper<JingdianleixingEntity> ew = new EntityWrapper<JingdianleixingEntity>();

		PageUtils page = jingdianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianleixingEntity jingdianleixing, 
		HttpServletRequest request){
        EntityWrapper<JingdianleixingEntity> ew = new EntityWrapper<JingdianleixingEntity>();

		PageUtils page = jingdianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianleixingEntity jingdianleixing){
       	EntityWrapper<JingdianleixingEntity> ew = new EntityWrapper<JingdianleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianleixing, "jingdianleixing")); 
        return R.ok().put("data", jingdianleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianleixingEntity jingdianleixing){
        EntityWrapper< JingdianleixingEntity> ew = new EntityWrapper< JingdianleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianleixing, "jingdianleixing")); 
		JingdianleixingView jingdianleixingView =  jingdianleixingService.selectView(ew);
		return R.ok("查询景点类型成功").put("data", jingdianleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianleixingEntity jingdianleixing = jingdianleixingService.selectById(id);
		jingdianleixing = jingdianleixingService.selectView(new EntityWrapper<JingdianleixingEntity>().eq("id", id));
        return R.ok().put("data", jingdianleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianleixingEntity jingdianleixing = jingdianleixingService.selectById(id);
		jingdianleixing = jingdianleixingService.selectView(new EntityWrapper<JingdianleixingEntity>().eq("id", id));
        return R.ok().put("data", jingdianleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增景点类型")
    public R save(@RequestBody JingdianleixingEntity jingdianleixing, HttpServletRequest request){
    	jingdianleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianleixing);
        jingdianleixingService.insert(jingdianleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增景点类型")
    @RequestMapping("/add")
    public R add(@RequestBody JingdianleixingEntity jingdianleixing, HttpServletRequest request){
    	jingdianleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianleixing);
        jingdianleixingService.insert(jingdianleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改景点类型")
    public R update(@RequestBody JingdianleixingEntity jingdianleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianleixing);
        jingdianleixingService.updateById(jingdianleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除景点类型")
    public R delete(@RequestBody Long[] ids){
        jingdianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
