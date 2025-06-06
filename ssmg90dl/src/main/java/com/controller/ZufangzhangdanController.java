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

import com.entity.ZufangzhangdanEntity;
import com.entity.view.ZufangzhangdanView;

import com.service.ZufangzhangdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 租房账单
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
@RestController
@RequestMapping("/zufangzhangdan")
public class ZufangzhangdanController {
    @Autowired
    private ZufangzhangdanService zufangzhangdanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZufangzhangdanEntity zufangzhangdan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zufangzhangdan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZufangzhangdanEntity> ew = new EntityWrapper<ZufangzhangdanEntity>();
		PageUtils page = zufangzhangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zufangzhangdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZufangzhangdanEntity zufangzhangdan, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zufangzhangdan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZufangzhangdanEntity> ew = new EntityWrapper<ZufangzhangdanEntity>();
		PageUtils page = zufangzhangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zufangzhangdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZufangzhangdanEntity zufangzhangdan){
       	EntityWrapper<ZufangzhangdanEntity> ew = new EntityWrapper<ZufangzhangdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zufangzhangdan, "zufangzhangdan")); 
        return R.ok().put("data", zufangzhangdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZufangzhangdanEntity zufangzhangdan){
        EntityWrapper< ZufangzhangdanEntity> ew = new EntityWrapper< ZufangzhangdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zufangzhangdan, "zufangzhangdan")); 
		ZufangzhangdanView zufangzhangdanView =  zufangzhangdanService.selectView(ew);
		return R.ok("查询租房账单成功").put("data", zufangzhangdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZufangzhangdanEntity zufangzhangdan = zufangzhangdanService.selectById(id);
        return R.ok().put("data", zufangzhangdan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZufangzhangdanEntity zufangzhangdan = zufangzhangdanService.selectById(id);
        return R.ok().put("data", zufangzhangdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZufangzhangdanEntity zufangzhangdan, HttpServletRequest request){
    	zufangzhangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zufangzhangdan);

        zufangzhangdanService.insert(zufangzhangdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZufangzhangdanEntity zufangzhangdan, HttpServletRequest request){
    	zufangzhangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zufangzhangdan);
    	zufangzhangdan.setUserid((Long)request.getSession().getAttribute("userId"));

        zufangzhangdanService.insert(zufangzhangdan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZufangzhangdanEntity zufangzhangdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zufangzhangdan);
        zufangzhangdanService.updateById(zufangzhangdan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zufangzhangdanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZufangzhangdanEntity> wrapper = new EntityWrapper<ZufangzhangdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zufangzhangdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
