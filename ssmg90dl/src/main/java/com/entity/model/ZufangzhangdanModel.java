package com.entity.model;

import com.entity.ZufangzhangdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 租房账单
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public class ZufangzhangdanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋名称
	 */
	
	private String fangwumingcheng;
		
	/**
	 * 房屋类型
	 */
	
	private String fangwuleixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 水电费
	 */
	
	private Integer shuidianfei;
		
	/**
	 * 物业费
	 */
	
	private Integer wuyefei;
		
	/**
	 * 房租费
	 */
	
	private Integer fangzufei;
		
	/**
	 * 账单详情
	 */
	
	private String zhangdanxiangqing;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：房屋名称
	 */
	 
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
				
	
	/**
	 * 设置：房屋类型
	 */
	 
	public void setFangwuleixing(String fangwuleixing) {
		this.fangwuleixing = fangwuleixing;
	}
	
	/**
	 * 获取：房屋类型
	 */
	public String getFangwuleixing() {
		return fangwuleixing;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：水电费
	 */
	 
	public void setShuidianfei(Integer shuidianfei) {
		this.shuidianfei = shuidianfei;
	}
	
	/**
	 * 获取：水电费
	 */
	public Integer getShuidianfei() {
		return shuidianfei;
	}
				
	
	/**
	 * 设置：物业费
	 */
	 
	public void setWuyefei(Integer wuyefei) {
		this.wuyefei = wuyefei;
	}
	
	/**
	 * 获取：物业费
	 */
	public Integer getWuyefei() {
		return wuyefei;
	}
				
	
	/**
	 * 设置：房租费
	 */
	 
	public void setFangzufei(Integer fangzufei) {
		this.fangzufei = fangzufei;
	}
	
	/**
	 * 获取：房租费
	 */
	public Integer getFangzufei() {
		return fangzufei;
	}
				
	
	/**
	 * 设置：账单详情
	 */
	 
	public void setZhangdanxiangqing(String zhangdanxiangqing) {
		this.zhangdanxiangqing = zhangdanxiangqing;
	}
	
	/**
	 * 获取：账单详情
	 */
	public String getZhangdanxiangqing() {
		return zhangdanxiangqing;
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
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
