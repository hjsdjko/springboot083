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

import com.cl.entity.DiscussmeishixinxiEntity;
import com.cl.entity.view.DiscussmeishixinxiView;

import com.cl.service.DiscussmeishixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 美食信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/discussmeishixinxi")
public class DiscussmeishixinxiController {
    @Autowired
    private DiscussmeishixinxiService discussmeishixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussmeishixinxiEntity discussmeishixinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussmeishixinxiEntity> ew = new EntityWrapper<DiscussmeishixinxiEntity>();

		PageUtils page = discussmeishixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmeishixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussmeishixinxiEntity discussmeishixinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussmeishixinxiEntity> ew = new EntityWrapper<DiscussmeishixinxiEntity>();

		PageUtils page = discussmeishixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmeishixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussmeishixinxiEntity discussmeishixinxi){
       	EntityWrapper<DiscussmeishixinxiEntity> ew = new EntityWrapper<DiscussmeishixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussmeishixinxi, "discussmeishixinxi")); 
        return R.ok().put("data", discussmeishixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussmeishixinxiEntity discussmeishixinxi){
        EntityWrapper< DiscussmeishixinxiEntity> ew = new EntityWrapper< DiscussmeishixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussmeishixinxi, "discussmeishixinxi")); 
		DiscussmeishixinxiView discussmeishixinxiView =  discussmeishixinxiService.selectView(ew);
		return R.ok("查询美食信息评论表成功").put("data", discussmeishixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussmeishixinxiEntity discussmeishixinxi = discussmeishixinxiService.selectById(id);
		discussmeishixinxi = discussmeishixinxiService.selectView(new EntityWrapper<DiscussmeishixinxiEntity>().eq("id", id));
        return R.ok().put("data", discussmeishixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussmeishixinxiEntity discussmeishixinxi = discussmeishixinxiService.selectById(id);
		discussmeishixinxi = discussmeishixinxiService.selectView(new EntityWrapper<DiscussmeishixinxiEntity>().eq("id", id));
        return R.ok().put("data", discussmeishixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增美食信息评论表")
    public R save(@RequestBody DiscussmeishixinxiEntity discussmeishixinxi, HttpServletRequest request){
    	discussmeishixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussmeishixinxi);
        discussmeishixinxiService.insert(discussmeishixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增美食信息评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussmeishixinxiEntity discussmeishixinxi, HttpServletRequest request){
    	discussmeishixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussmeishixinxi);
        discussmeishixinxiService.insert(discussmeishixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussmeishixinxiEntity discussmeishixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmeishixinxi);
        discussmeishixinxiService.updateById(discussmeishixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除美食信息评论表")
    public R delete(@RequestBody Long[] ids){
        discussmeishixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussmeishixinxiEntity discussmeishixinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussmeishixinxiEntity> ew = new EntityWrapper<DiscussmeishixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussmeishixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmeishixinxi), params), params));
        return R.ok().put("data", page);
    }








}
