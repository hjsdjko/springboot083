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

import com.cl.entity.MeishileixingEntity;
import com.cl.entity.view.MeishileixingView;

import com.cl.service.MeishileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 美食类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@RestController
@RequestMapping("/meishileixing")
public class MeishileixingController {
    @Autowired
    private MeishileixingService meishileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishileixingEntity meishileixing,
		HttpServletRequest request){
        EntityWrapper<MeishileixingEntity> ew = new EntityWrapper<MeishileixingEntity>();

		PageUtils page = meishileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishileixingEntity meishileixing, 
		HttpServletRequest request){
        EntityWrapper<MeishileixingEntity> ew = new EntityWrapper<MeishileixingEntity>();

		PageUtils page = meishileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishileixingEntity meishileixing){
       	EntityWrapper<MeishileixingEntity> ew = new EntityWrapper<MeishileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishileixing, "meishileixing")); 
        return R.ok().put("data", meishileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishileixingEntity meishileixing){
        EntityWrapper< MeishileixingEntity> ew = new EntityWrapper< MeishileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishileixing, "meishileixing")); 
		MeishileixingView meishileixingView =  meishileixingService.selectView(ew);
		return R.ok("查询美食类型成功").put("data", meishileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishileixingEntity meishileixing = meishileixingService.selectById(id);
		meishileixing = meishileixingService.selectView(new EntityWrapper<MeishileixingEntity>().eq("id", id));
        return R.ok().put("data", meishileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishileixingEntity meishileixing = meishileixingService.selectById(id);
		meishileixing = meishileixingService.selectView(new EntityWrapper<MeishileixingEntity>().eq("id", id));
        return R.ok().put("data", meishileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增美食类型")
    public R save(@RequestBody MeishileixingEntity meishileixing, HttpServletRequest request){
    	meishileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishileixing);
        meishileixingService.insert(meishileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增美食类型")
    @RequestMapping("/add")
    public R add(@RequestBody MeishileixingEntity meishileixing, HttpServletRequest request){
    	meishileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishileixing);
        meishileixingService.insert(meishileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改美食类型")
    public R update(@RequestBody MeishileixingEntity meishileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishileixing);
        meishileixingService.updateById(meishileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除美食类型")
    public R delete(@RequestBody Long[] ids){
        meishileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
