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

import com.cl.entity.LvyougonglveEntity;
import com.cl.entity.view.LvyougonglveView;

import com.cl.service.LvyougonglveService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 旅游攻略
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@RestController
@RequestMapping("/lvyougonglve")
public class LvyougonglveController {
    @Autowired
    private LvyougonglveService lvyougonglveService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LvyougonglveEntity lvyougonglve,
		HttpServletRequest request){
        EntityWrapper<LvyougonglveEntity> ew = new EntityWrapper<LvyougonglveEntity>();

		PageUtils page = lvyougonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyougonglve), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LvyougonglveEntity lvyougonglve, 
		HttpServletRequest request){
        EntityWrapper<LvyougonglveEntity> ew = new EntityWrapper<LvyougonglveEntity>();

		PageUtils page = lvyougonglveService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyougonglve), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LvyougonglveEntity lvyougonglve){
       	EntityWrapper<LvyougonglveEntity> ew = new EntityWrapper<LvyougonglveEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lvyougonglve, "lvyougonglve")); 
        return R.ok().put("data", lvyougonglveService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LvyougonglveEntity lvyougonglve){
        EntityWrapper< LvyougonglveEntity> ew = new EntityWrapper< LvyougonglveEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lvyougonglve, "lvyougonglve")); 
		LvyougonglveView lvyougonglveView =  lvyougonglveService.selectView(ew);
		return R.ok("查询旅游攻略成功").put("data", lvyougonglveView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LvyougonglveEntity lvyougonglve = lvyougonglveService.selectById(id);
		lvyougonglve = lvyougonglveService.selectView(new EntityWrapper<LvyougonglveEntity>().eq("id", id));
        return R.ok().put("data", lvyougonglve);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LvyougonglveEntity lvyougonglve = lvyougonglveService.selectById(id);
		lvyougonglve = lvyougonglveService.selectView(new EntityWrapper<LvyougonglveEntity>().eq("id", id));
        return R.ok().put("data", lvyougonglve);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增旅游攻略")
    public R save(@RequestBody LvyougonglveEntity lvyougonglve, HttpServletRequest request){
    	lvyougonglve.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lvyougonglve);
        lvyougonglveService.insert(lvyougonglve);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增旅游攻略")
    @RequestMapping("/add")
    public R add(@RequestBody LvyougonglveEntity lvyougonglve, HttpServletRequest request){
    	lvyougonglve.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lvyougonglve);
        lvyougonglveService.insert(lvyougonglve);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改旅游攻略")
    public R update(@RequestBody LvyougonglveEntity lvyougonglve, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lvyougonglve);
        lvyougonglveService.updateById(lvyougonglve);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除旅游攻略")
    public R delete(@RequestBody Long[] ids){
        lvyougonglveService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
