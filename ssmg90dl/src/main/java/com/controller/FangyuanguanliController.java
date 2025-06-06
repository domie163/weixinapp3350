package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FangyuanguanliEntity;
import com.entity.view.FangyuanguanliView;

import com.service.FangyuanguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 房源管理
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
@RestController
@RequestMapping("/fangyuanguanli")
public class FangyuanguanliController {
    @Autowired
    private FangyuanguanliService fangyuanguanliService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyuanguanliEntity fangyuanguanli, 
		HttpServletRequest request){

        EntityWrapper<FangyuanguanliEntity> ew = new EntityWrapper<FangyuanguanliEntity>();
		PageUtils page = fangyuanguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanguanli), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyuanguanliEntity fangyuanguanli, HttpServletRequest request){
        EntityWrapper<FangyuanguanliEntity> ew = new EntityWrapper<FangyuanguanliEntity>();
		PageUtils page = fangyuanguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanguanli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyuanguanliEntity fangyuanguanli){
       	EntityWrapper<FangyuanguanliEntity> ew = new EntityWrapper<FangyuanguanliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyuanguanli, "fangyuanguanli")); 
        return R.ok().put("data", fangyuanguanliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyuanguanliEntity fangyuanguanli){
        EntityWrapper< FangyuanguanliEntity> ew = new EntityWrapper< FangyuanguanliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyuanguanli, "fangyuanguanli")); 
		FangyuanguanliView fangyuanguanliView =  fangyuanguanliService.selectView(ew);
		return R.ok("查询房源管理成功").put("data", fangyuanguanliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyuanguanliEntity fangyuanguanli = fangyuanguanliService.selectById(id);
        return R.ok().put("data", fangyuanguanli);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyuanguanliEntity fangyuanguanli = fangyuanguanliService.selectById(id);
        return R.ok().put("data", fangyuanguanli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanguanliEntity fangyuanguanli, HttpServletRequest request){
    	fangyuanguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanguanli);

        fangyuanguanliService.insert(fangyuanguanli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanguanliEntity fangyuanguanli, HttpServletRequest request){
    	fangyuanguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanguanli);

        fangyuanguanliService.insert(fangyuanguanli);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FangyuanguanliEntity fangyuanguanli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyuanguanli);
        fangyuanguanliService.updateById(fangyuanguanli);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyuanguanliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<FangyuanguanliEntity> wrapper = new EntityWrapper<FangyuanguanliEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = fangyuanguanliService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
