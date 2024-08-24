package com.cl.entity.view;

import com.cl.entity.YiliaofuwuzhanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 医疗服务站
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 13:41:46
 */
@TableName("yiliaofuwuzhan")
public class YiliaofuwuzhanView  extends YiliaofuwuzhanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiliaofuwuzhanView(){
	}
 
 	public YiliaofuwuzhanView(YiliaofuwuzhanEntity yiliaofuwuzhanEntity){
 	try {
			BeanUtils.copyProperties(this, yiliaofuwuzhanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
