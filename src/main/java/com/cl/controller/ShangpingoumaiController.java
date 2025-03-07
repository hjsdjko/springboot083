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

import com.cl.entity.ShangpingoumaiEntity;
import com.cl.entity.view.ShangpingoumaiView;

import com.cl.service.ShangpingoumaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 商品购买
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/shangpingoumai")
public class ShangpingoumaiController {
    @Autowired
    private ShangpingoumaiService shangpingoumaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpingoumaiEntity shangpingoumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shangpingoumai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shangjia")) {
			shangpingoumai.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangpingoumaiEntity> ew = new EntityWrapper<ShangpingoumaiEntity>();

		PageUtils page = shangpingoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpingoumai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpingoumaiEntity shangpingoumai, 
		HttpServletRequest request){
        EntityWrapper<ShangpingoumaiEntity> ew = new EntityWrapper<ShangpingoumaiEntity>();

		PageUtils page = shangpingoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpingoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpingoumaiEntity shangpingoumai){
       	EntityWrapper<ShangpingoumaiEntity> ew = new EntityWrapper<ShangpingoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpingoumai, "shangpingoumai")); 
        return R.ok().put("data", shangpingoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpingoumaiEntity shangpingoumai){
        EntityWrapper< ShangpingoumaiEntity> ew = new EntityWrapper< ShangpingoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpingoumai, "shangpingoumai")); 
		ShangpingoumaiView shangpingoumaiView =  shangpingoumaiService.selectView(ew);
		return R.ok("查询商品购买成功").put("data", shangpingoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpingoumaiEntity shangpingoumai = shangpingoumaiService.selectById(id);
		shangpingoumai = shangpingoumaiService.selectView(new EntityWrapper<ShangpingoumaiEntity>().eq("id", id));
        return R.ok().put("data", shangpingoumai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpingoumaiEntity shangpingoumai = shangpingoumaiService.selectById(id);
		shangpingoumai = shangpingoumaiService.selectView(new EntityWrapper<ShangpingoumaiEntity>().eq("id", id));
        return R.ok().put("data", shangpingoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增商品购买")
    public R save(@RequestBody ShangpingoumaiEntity shangpingoumai, HttpServletRequest request){
    	shangpingoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpingoumai);
        shangpingoumaiService.insert(shangpingoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增商品购买")
    @RequestMapping("/add")
    public R add(@RequestBody ShangpingoumaiEntity shangpingoumai, HttpServletRequest request){
    	shangpingoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpingoumai);
        shangpingoumaiService.insert(shangpingoumai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改商品购买")
    public R update(@RequestBody ShangpingoumaiEntity shangpingoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpingoumai);
        shangpingoumaiService.updateById(shangpingoumai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除商品购买")
    public R delete(@RequestBody Long[] ids){
        shangpingoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
