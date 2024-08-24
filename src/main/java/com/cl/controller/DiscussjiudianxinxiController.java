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

import com.cl.entity.DiscussjiudianxinxiEntity;
import com.cl.entity.view.DiscussjiudianxinxiView;

import com.cl.service.DiscussjiudianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 酒店信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/discussjiudianxinxi")
public class DiscussjiudianxinxiController {
    @Autowired
    private DiscussjiudianxinxiService discussjiudianxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiudianxinxiEntity discussjiudianxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussjiudianxinxiEntity> ew = new EntityWrapper<DiscussjiudianxinxiEntity>();

		PageUtils page = discussjiudianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiudianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiudianxinxiEntity discussjiudianxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiudianxinxiEntity> ew = new EntityWrapper<DiscussjiudianxinxiEntity>();

		PageUtils page = discussjiudianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiudianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiudianxinxiEntity discussjiudianxinxi){
       	EntityWrapper<DiscussjiudianxinxiEntity> ew = new EntityWrapper<DiscussjiudianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiudianxinxi, "discussjiudianxinxi")); 
        return R.ok().put("data", discussjiudianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiudianxinxiEntity discussjiudianxinxi){
        EntityWrapper< DiscussjiudianxinxiEntity> ew = new EntityWrapper< DiscussjiudianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiudianxinxi, "discussjiudianxinxi")); 
		DiscussjiudianxinxiView discussjiudianxinxiView =  discussjiudianxinxiService.selectView(ew);
		return R.ok("查询酒店信息评论表成功").put("data", discussjiudianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiudianxinxiEntity discussjiudianxinxi = discussjiudianxinxiService.selectById(id);
		discussjiudianxinxi = discussjiudianxinxiService.selectView(new EntityWrapper<DiscussjiudianxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussjiudianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiudianxinxiEntity discussjiudianxinxi = discussjiudianxinxiService.selectById(id);
		discussjiudianxinxi = discussjiudianxinxiService.selectView(new EntityWrapper<DiscussjiudianxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussjiudianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增酒店信息评论表")
    public R save(@RequestBody DiscussjiudianxinxiEntity discussjiudianxinxi, HttpServletRequest request){
    	discussjiudianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiudianxinxi);
        discussjiudianxinxiService.insert(discussjiudianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增酒店信息评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiudianxinxiEntity discussjiudianxinxi, HttpServletRequest request){
    	discussjiudianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiudianxinxi);
        discussjiudianxinxiService.insert(discussjiudianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiudianxinxiEntity discussjiudianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiudianxinxi);
        discussjiudianxinxiService.updateById(discussjiudianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除酒店信息评论表")
    public R delete(@RequestBody Long[] ids){
        discussjiudianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiudianxinxiEntity discussjiudianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiudianxinxiEntity> ew = new EntityWrapper<DiscussjiudianxinxiEntity>();
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
		PageUtils page = discussjiudianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiudianxinxi), params), params));
        return R.ok().put("data", page);
    }








}
