package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 旅游攻略
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 13:41:45
 */
@TableName("lvyougonglve")
public class LvyougonglveEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LvyougonglveEntity() {
		
	}
	
	public LvyougonglveEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 攻略标题
	 */
					
	private String gonglvebiaoti;
	
	/**
	 * 景点名称
	 */
					
	private String jingdianmingcheng;
	
	/**
	 * 景点图片
	 */
					
	private String jingdiantupian;
	
	/**
	 * 游玩天数
	 */
					
	private String youwantianshu;
	
	/**
	 * 行程路线
	 */
					
	private String xingchengluxian;
	
	/**
	 * 起点
	 */
					
	private String qidian;
	
	/**
	 * 终点
	 */
					
	private String zhongdian;
	
	/**
	 * 出行方式
	 */
					
	private String chuxingfangshi;
	
	/**
	 * 攻略详情
	 */
					
	private String gonglvexiangqing;
	
	/**
	 * 酒店推荐
	 */
					
	private String jiudiantuijian;
	
	/**
	 * 美食推荐
	 */
					
	private String meishituijian;
	
	/**
	 * 视频
	 */
					
	private String shipin;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：攻略标题
	 */
	public void setGonglvebiaoti(String gonglvebiaoti) {
		this.gonglvebiaoti = gonglvebiaoti;
	}
	/**
	 * 获取：攻略标题
	 */
	public String getGonglvebiaoti() {
		return gonglvebiaoti;
	}
	/**
	 * 设置：景点名称
	 */
	public void setJingdianmingcheng(String jingdianmingcheng) {
		this.jingdianmingcheng = jingdianmingcheng;
	}
	/**
	 * 获取：景点名称
	 */
	public String getJingdianmingcheng() {
		return jingdianmingcheng;
	}
	/**
	 * 设置：景点图片
	 */
	public void setJingdiantupian(String jingdiantupian) {
		this.jingdiantupian = jingdiantupian;
	}
	/**
	 * 获取：景点图片
	 */
	public String getJingdiantupian() {
		return jingdiantupian;
	}
	/**
	 * 设置：游玩天数
	 */
	public void setYouwantianshu(String youwantianshu) {
		this.youwantianshu = youwantianshu;
	}
	/**
	 * 获取：游玩天数
	 */
	public String getYouwantianshu() {
		return youwantianshu;
	}
	/**
	 * 设置：行程路线
	 */
	public void setXingchengluxian(String xingchengluxian) {
		this.xingchengluxian = xingchengluxian;
	}
	/**
	 * 获取：行程路线
	 */
	public String getXingchengluxian() {
		return xingchengluxian;
	}
	/**
	 * 设置：起点
	 */
	public void setQidian(String qidian) {
		this.qidian = qidian;
	}
	/**
	 * 获取：起点
	 */
	public String getQidian() {
		return qidian;
	}
	/**
	 * 设置：终点
	 */
	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}
	/**
	 * 获取：终点
	 */
	public String getZhongdian() {
		return zhongdian;
	}
	/**
	 * 设置：出行方式
	 */
	public void setChuxingfangshi(String chuxingfangshi) {
		this.chuxingfangshi = chuxingfangshi;
	}
	/**
	 * 获取：出行方式
	 */
	public String getChuxingfangshi() {
		return chuxingfangshi;
	}
	/**
	 * 设置：攻略详情
	 */
	public void setGonglvexiangqing(String gonglvexiangqing) {
		this.gonglvexiangqing = gonglvexiangqing;
	}
	/**
	 * 获取：攻略详情
	 */
	public String getGonglvexiangqing() {
		return gonglvexiangqing;
	}
	/**
	 * 设置：酒店推荐
	 */
	public void setJiudiantuijian(String jiudiantuijian) {
		this.jiudiantuijian = jiudiantuijian;
	}
	/**
	 * 获取：酒店推荐
	 */
	public String getJiudiantuijian() {
		return jiudiantuijian;
	}
	/**
	 * 设置：美食推荐
	 */
	public void setMeishituijian(String meishituijian) {
		this.meishituijian = meishituijian;
	}
	/**
	 * 获取：美食推荐
	 */
	public String getMeishituijian() {
		return meishituijian;
	}
	/**
	 * 设置：视频
	 */
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	/**
	 * 获取：视频
	 */
	public String getShipin() {
		return shipin;
	}

}
