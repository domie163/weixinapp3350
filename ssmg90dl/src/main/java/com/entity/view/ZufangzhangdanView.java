package com.entity.view;

import com.entity.ZufangzhangdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 租房账单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
@TableName("zufangzhangdan")
public class ZufangzhangdanView  extends ZufangzhangdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZufangzhangdanView(){
	}
 
 	public ZufangzhangdanView(ZufangzhangdanEntity zufangzhangdanEntity){
 	try {
			BeanUtils.copyProperties(this, zufangzhangdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
