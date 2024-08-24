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

import com.cl.entity.JingdianxinxiEntity;
import com.cl.entity.view.JingdianxinxiView;

import com.cl.service.JingdianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 景点信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@RestController
@RequestMapping("/jingdianxinxi")
public class JingdianxinxiController {
    @Autowired
    private JingdianxinxiService jingdianxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi,
		HttpServletRequest request){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();

		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi, 
		HttpServletRequest request){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();

		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianxinxiEntity jingdianxinxi){
       	EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianxinxi, "jingdianxinxi")); 
        return R.ok().put("data", jingdianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianxinxiEntity jingdianxinxi){
        EntityWrapper< JingdianxinxiEntity> ew = new EntityWrapper< JingdianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianxinxi, "jingdianxinxi")); 
		JingdianxinxiView jingdianxinxiView =  jingdianxinxiService.selectView(ew);
		return R.ok("查询景点信息成功").put("data", jingdianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianxinxiEntity jingdianxinxi = jingdianxinxiService.selectById(id);
		jingdianxinxi.setClicknum(jingdianxinxi.getClicknum()+1);
		jingdianxinxiService.updateById(jingdianxinxi);
		jingdianxinxi = jingdianxinxiService.selectView(new EntityWrapper<JingdianxinxiEntity>().eq("id", id));
        return R.ok().put("data", jingdianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianxinxiEntity jingdianxinxi = jingdianxinxiService.selectById(id);
		jingdianxinxi.setClicknum(jingdianxinxi.getClicknum()+1);
		jingdianxinxiService.updateById(jingdianxinxi);
		jingdianxinxi = jingdianxinxiService.selectView(new EntityWrapper<JingdianxinxiEntity>().eq("id", id));
        return R.ok().put("data", jingdianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增景点信息")
    public R save(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
    	jingdianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.insert(jingdianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增景点信息")
    @RequestMapping("/add")
    public R add(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
    	jingdianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.insert(jingdianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改景点信息")
    public R update(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.updateById(jingdianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除景点信息")
    public R delete(@RequestBody Long[] ids){
        jingdianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
