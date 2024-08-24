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

import com.cl.entity.JiudianleixingEntity;
import com.cl.entity.view.JiudianleixingView;

import com.cl.service.JiudianleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 酒店类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@RestController
@RequestMapping("/jiudianleixing")
public class JiudianleixingController {
    @Autowired
    private JiudianleixingService jiudianleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiudianleixingEntity jiudianleixing,
		HttpServletRequest request){
        EntityWrapper<JiudianleixingEntity> ew = new EntityWrapper<JiudianleixingEntity>();

		PageUtils page = jiudianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudianleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiudianleixingEntity jiudianleixing, 
		HttpServletRequest request){
        EntityWrapper<JiudianleixingEntity> ew = new EntityWrapper<JiudianleixingEntity>();

		PageUtils page = jiudianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudianleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiudianleixingEntity jiudianleixing){
       	EntityWrapper<JiudianleixingEntity> ew = new EntityWrapper<JiudianleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiudianleixing, "jiudianleixing")); 
        return R.ok().put("data", jiudianleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiudianleixingEntity jiudianleixing){
        EntityWrapper< JiudianleixingEntity> ew = new EntityWrapper< JiudianleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiudianleixing, "jiudianleixing")); 
		JiudianleixingView jiudianleixingView =  jiudianleixingService.selectView(ew);
		return R.ok("查询酒店类型成功").put("data", jiudianleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiudianleixingEntity jiudianleixing = jiudianleixingService.selectById(id);
		jiudianleixing = jiudianleixingService.selectView(new EntityWrapper<JiudianleixingEntity>().eq("id", id));
        return R.ok().put("data", jiudianleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiudianleixingEntity jiudianleixing = jiudianleixingService.selectById(id);
		jiudianleixing = jiudianleixingService.selectView(new EntityWrapper<JiudianleixingEntity>().eq("id", id));
        return R.ok().put("data", jiudianleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增酒店类型")
    public R save(@RequestBody JiudianleixingEntity jiudianleixing, HttpServletRequest request){
    	jiudianleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiudianleixing);
        jiudianleixingService.insert(jiudianleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增酒店类型")
    @RequestMapping("/add")
    public R add(@RequestBody JiudianleixingEntity jiudianleixing, HttpServletRequest request){
    	jiudianleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiudianleixing);
        jiudianleixingService.insert(jiudianleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改酒店类型")
    public R update(@RequestBody JiudianleixingEntity jiudianleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiudianleixing);
        jiudianleixingService.updateById(jiudianleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除酒店类型")
    public R delete(@RequestBody Long[] ids){
        jiudianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
