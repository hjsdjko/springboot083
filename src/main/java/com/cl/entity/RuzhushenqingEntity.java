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
 * 入住申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@TableName("ruzhushenqing")
public class RuzhushenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RuzhushenqingEntity() {
		
	}
	
	public RuzhushenqingEntity(T t) {
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
	 * 摊位地址
	 */
					
	private String tanweidizhi;
	
	/**
	 * 租金元/月
	 */
					
	private Double zujin;
	
	/**
	 * 租赁月数
	 */
					
	private Integer zulinyueshu;
	
	/**
	 * 总价
	 */
					
	private Double zongjia;
	
	/**
	 * 经营范围
	 */
					
	private String jingyingfanwei;
	
	/**
	 * 产品信息
	 */
					
	private String chanpinxinxi;
	
	/**
	 * 商家账号
	 */
					
	private String shangjiazhanghao;
	
	/**
	 * 商家姓名
	 */
					
	private String shangjiaxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：租赁月数
	 */
	public void setZulinyueshu(Integer zulinyueshu) {
		this.zulinyueshu = zulinyueshu;
	}
	/**
	 * 获取：租赁月数
	 */
	public Integer getZulinyueshu() {
		return zulinyueshu;
	}
	/**
	 * 设置：总价
	 */
	public void setZongjia(Double zongjia) {
		this.zongjia = zongjia;
	}
	/**
	 * 获取：总价
	 */
	public Double getZongjia() {
		return zongjia;
	}
	/**
	 * 设置：经营范围
	 */
	public void setJingyingfanwei(String jingyingfanwei) {
		this.jingyingfanwei = jingyingfanwei;
	}
	/**
	 * 获取：经营范围
	 */
	public String getJingyingfanwei() {
		return jingyingfanwei;
	}
	/**
	 * 设置：产品信息
	 */
	public void setChanpinxinxi(String chanpinxinxi) {
		this.chanpinxinxi = chanpinxinxi;
	}
	/**
	 * 获取：产品信息
	 */
	public String getChanpinxinxi() {
		return chanpinxinxi;
	}
	/**
	 * 设置：商家账号
	 */
	public void setShangjiazhanghao(String shangjiazhanghao) {
		this.shangjiazhanghao = shangjiazhanghao;
	}
	/**
	 * 获取：商家账号
	 */
	public String getShangjiazhanghao() {
		return shangjiazhanghao;
	}
	/**
	 * 设置：商家姓名
	 */
	public void setShangjiaxingming(String shangjiaxingming) {
		this.shangjiaxingming = shangjiaxingming;
	}
	/**
	 * 获取：商家姓名
	 */
	public String getShangjiaxingming() {
		return shangjiaxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
