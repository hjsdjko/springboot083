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

import com.cl.entity.RuzhushenqingEntity;
import com.cl.entity.view.RuzhushenqingView;

import com.cl.service.RuzhushenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 入住申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@RestController
@RequestMapping("/ruzhushenqing")
public class RuzhushenqingController {
    @Autowired
    private RuzhushenqingService ruzhushenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RuzhushenqingEntity ruzhushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			ruzhushenqing.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RuzhushenqingEntity> ew = new EntityWrapper<RuzhushenqingEntity>();

		PageUtils page = ruzhushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ruzhushenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RuzhushenqingEntity ruzhushenqing, 
		HttpServletRequest request){
        EntityWrapper<RuzhushenqingEntity> ew = new EntityWrapper<RuzhushenqingEntity>();

		PageUtils page = ruzhushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ruzhushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RuzhushenqingEntity ruzhushenqing){
       	EntityWrapper<RuzhushenqingEntity> ew = new EntityWrapper<RuzhushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ruzhushenqing, "ruzhushenqing")); 
        return R.ok().put("data", ruzhushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RuzhushenqingEntity ruzhushenqing){
        EntityWrapper< RuzhushenqingEntity> ew = new EntityWrapper< RuzhushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ruzhushenqing, "ruzhushenqing")); 
		RuzhushenqingView ruzhushenqingView =  ruzhushenqingService.selectView(ew);
		return R.ok("查询入住申请成功").put("data", ruzhushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RuzhushenqingEntity ruzhushenqing = ruzhushenqingService.selectById(id);
		ruzhushenqing = ruzhushenqingService.selectView(new EntityWrapper<RuzhushenqingEntity>().eq("id", id));
        return R.ok().put("data", ruzhushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RuzhushenqingEntity ruzhushenqing = ruzhushenqingService.selectById(id);
		ruzhushenqing = ruzhushenqingService.selectView(new EntityWrapper<RuzhushenqingEntity>().eq("id", id));
        return R.ok().put("data", ruzhushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增入住申请")
    public R save(@RequestBody RuzhushenqingEntity ruzhushenqing, HttpServletRequest request){
    	ruzhushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ruzhushenqing);
        ruzhushenqingService.insert(ruzhushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增入住申请")
    @RequestMapping("/add")
    public R add(@RequestBody RuzhushenqingEntity ruzhushenqing, HttpServletRequest request){
    	ruzhushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ruzhushenqing);
        ruzhushenqingService.insert(ruzhushenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改入住申请")
    public R update(@RequestBody RuzhushenqingEntity ruzhushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ruzhushenqing);
        ruzhushenqingService.updateById(ruzhushenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核入住申请")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<RuzhushenqingEntity> list = new ArrayList<RuzhushenqingEntity>();
        for(Long id : ids) {
            RuzhushenqingEntity ruzhushenqing = ruzhushenqingService.selectById(id);
            ruzhushenqing.setSfsh(sfsh);
            ruzhushenqing.setShhf(shhf);
            list.add(ruzhushenqing);
        }
        ruzhushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除入住申请")
    public R delete(@RequestBody Long[] ids){
        ruzhushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
