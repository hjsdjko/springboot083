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
 * 摊位信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@TableName("tanweixinxi")
public class TanweixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TanweixinxiEntity() {
		
	}
	
	public TanweixinxiEntity(T t) {
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
	 * 摊位名称
	 */
					
	private String tanweimingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 摊位地址
	 */
					
	private String tanweidizhi;
	
	/**
	 * 租金元/月
	 */
					
	private Double zujin;
	
	/**
	 * 面积
	 */
					
	private Double mianji;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	
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
	 * 设置：摊位名称
	 */
	public void setTanweimingcheng(String tanweimingcheng) {
		this.tanweimingcheng = tanweimingcheng;
	}
	/**
	 * 获取：摊位名称
	 */
	public String getTanweimingcheng() {
		return tanweimingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：摊位地址
	 */
	public void setTanweidizhi(String tanweidizhi) {
		this.tanweidizhi = tanweidizhi;
	}
	/**
	 * 获取：摊位地址
	 */
	public String getTanweidizhi() {
		return tanweidizhi;
	}
	/**
	 * 设置：租金元/月
	 */
	public void setZujin(Double zujin) {
		this.zujin = zujin;
	}
	/**
	 * 获取：租金元/月
	 */
	public Double getZujin() {
		return zujin;
	}
	/**
	 * 设置：面积
	 */
	public void setMianji(Double mianji) {
		this.mianji = mianji;
	}
	/**
	 * 获取：面积
	 */
	public Double getMianji() {
		return mianji;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}

}
