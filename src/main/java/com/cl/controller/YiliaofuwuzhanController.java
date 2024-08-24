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

import com.cl.entity.YiliaofuwuzhanEntity;
import com.cl.entity.view.YiliaofuwuzhanView;

import com.cl.service.YiliaofuwuzhanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 医疗服务站
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/yiliaofuwuzhan")
public class YiliaofuwuzhanController {
    @Autowired
    private YiliaofuwuzhanService yiliaofuwuzhanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YiliaofuwuzhanEntity yiliaofuwuzhan,
		HttpServletRequest request){
        EntityWrapper<YiliaofuwuzhanEntity> ew = new EntityWrapper<YiliaofuwuzhanEntity>();

		PageUtils page = yiliaofuwuzhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaofuwuzhan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YiliaofuwuzhanEntity yiliaofuwuzhan, 
		HttpServletRequest request){
        EntityWrapper<YiliaofuwuzhanEntity> ew = new EntityWrapper<YiliaofuwuzhanEntity>();

		PageUtils page = yiliaofuwuzhanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaofuwuzhan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiliaofuwuzhanEntity yiliaofuwuzhan){
       	EntityWrapper<YiliaofuwuzhanEntity> ew = new EntityWrapper<YiliaofuwuzhanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yiliaofuwuzhan, "yiliaofuwuzhan")); 
        return R.ok().put("data", yiliaofuwuzhanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiliaofuwuzhanEntity yiliaofuwuzhan){
        EntityWrapper< YiliaofuwuzhanEntity> ew = new EntityWrapper< YiliaofuwuzhanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yiliaofuwuzhan, "yiliaofuwuzhan")); 
		YiliaofuwuzhanView yiliaofuwuzhanView =  yiliaofuwuzhanService.selectView(ew);
		return R.ok("查询医疗服务站成功").put("data", yiliaofuwuzhanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiliaofuwuzhanEntity yiliaofuwuzhan = yiliaofuwuzhanService.selectById(id);
		yiliaofuwuzhan = yiliaofuwuzhanService.selectView(new EntityWrapper<YiliaofuwuzhanEntity>().eq("id", id));
        return R.ok().put("data", yiliaofuwuzhan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiliaofuwuzhanEntity yiliaofuwuzhan = yiliaofuwuzhanService.selectById(id);
		yiliaofuwuzhan = yiliaofuwuzhanService.selectView(new EntityWrapper<YiliaofuwuzhanEntity>().eq("id", id));
        return R.ok().put("data", yiliaofuwuzhan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增医疗服务站")
    public R save(@RequestBody YiliaofuwuzhanEntity yiliaofuwuzhan, HttpServletRequest request){
    	yiliaofuwuzhan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiliaofuwuzhan);
        yiliaofuwuzhanService.insert(yiliaofuwuzhan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增医疗服务站")
    @RequestMapping("/add")
    public R add(@RequestBody YiliaofuwuzhanEntity yiliaofuwuzhan, HttpServletRequest request){
    	yiliaofuwuzhan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiliaofuwuzhan);
        yiliaofuwuzhanService.insert(yiliaofuwuzhan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改医疗服务站")
    public R update(@RequestBody YiliaofuwuzhanEntity yiliaofuwuzhan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yiliaofuwuzhan);
        yiliaofuwuzhanService.updateById(yiliaofuwuzhan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除医疗服务站")
    public R delete(@RequestBody Long[] ids){
        yiliaofuwuzhanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
