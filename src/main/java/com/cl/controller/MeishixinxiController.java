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
import com.cl.utils.UserBasedCollaborativeFiltering;

import com.cl.entity.MeishixinxiEntity;
import com.cl.entity.view.MeishixinxiView;

import com.cl.service.MeishixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 美食信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@RestController
@RequestMapping("/meishixinxi")
public class MeishixinxiController {
    @Autowired
    private MeishixinxiService meishixinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishixinxiEntity meishixinxi,
		HttpServletRequest request){
        EntityWrapper<MeishixinxiEntity> ew = new EntityWrapper<MeishixinxiEntity>();

		PageUtils page = meishixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishixinxiEntity meishixinxi, 
		HttpServletRequest request){
        EntityWrapper<MeishixinxiEntity> ew = new EntityWrapper<MeishixinxiEntity>();

		PageUtils page = meishixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishixinxiEntity meishixinxi){
       	EntityWrapper<MeishixinxiEntity> ew = new EntityWrapper<MeishixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishixinxi, "meishixinxi")); 
        return R.ok().put("data", meishixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishixinxiEntity meishixinxi){
        EntityWrapper< MeishixinxiEntity> ew = new EntityWrapper< MeishixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishixinxi, "meishixinxi")); 
		MeishixinxiView meishixinxiView =  meishixinxiService.selectView(ew);
		return R.ok("查询美食信息成功").put("data", meishixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishixinxiEntity meishixinxi = meishixinxiService.selectById(id);
		meishixinxi.setClicknum(meishixinxi.getClicknum()+1);
		meishixinxiService.updateById(meishixinxi);
		meishixinxi = meishixinxiService.selectView(new EntityWrapper<MeishixinxiEntity>().eq("id", id));
        return R.ok().put("data", meishixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishixinxiEntity meishixinxi = meishixinxiService.selectById(id);
		meishixinxi.setClicknum(meishixinxi.getClicknum()+1);
		meishixinxiService.updateById(meishixinxi);
		meishixinxi = meishixinxiService.selectView(new EntityWrapper<MeishixinxiEntity>().eq("id", id));
        return R.ok().put("data", meishixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增美食信息")
    public R save(@RequestBody MeishixinxiEntity meishixinxi, HttpServletRequest request){
    	meishixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishixinxi);
        meishixinxiService.insert(meishixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增美食信息")
    @RequestMapping("/add")
    public R add(@RequestBody MeishixinxiEntity meishixinxi, HttpServletRequest request){
    	meishixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishixinxi);
        meishixinxiService.insert(meishixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改美食信息")
    public R update(@RequestBody MeishixinxiEntity meishixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishixinxi);
        meishixinxiService.updateById(meishixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除美食信息")
    public R delete(@RequestBody Long[] ids){
        meishixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MeishixinxiEntity meishixinxi, HttpServletRequest request,String pre){
        EntityWrapper<MeishixinxiEntity> ew = new EntityWrapper<MeishixinxiEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = meishixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishixinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,MeishixinxiEntity meishixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "meishixinxi"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity storeup : storeups) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(storeup.getUserid().toString())) {
                    userRatings = ratings.get(storeup.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(storeup.getUserid().toString(), userRatings);
                }

                if(userRatings.containsKey(storeup.getRefid().toString())) {
                    userRatings.put(storeup.getRefid().toString(), userRatings.get(storeup.getRefid().toString())+1.0);
                } else {
                    userRatings.put(storeup.getRefid().toString(), 1.0);
                }
            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<MeishixinxiEntity> ew = new EntityWrapper<MeishixinxiEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = meishixinxiService.queryPage(params, ew);
        List<MeishixinxiEntity> pageList = (List<MeishixinxiEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<MeishixinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(meishixinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }







}
