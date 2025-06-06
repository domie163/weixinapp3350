package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangyuanguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangyuanguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanguanliView;


/**
 * 房源管理
 *
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface FangyuanguanliService extends IService<FangyuanguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanguanliVO> selectListVO(Wrapper<FangyuanguanliEntity> wrapper);
   	
   	FangyuanguanliVO selectVO(@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);
   	
   	List<FangyuanguanliView> selectListView(Wrapper<FangyuanguanliEntity> wrapper);
   	
   	FangyuanguanliView selectView(@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanguanliEntity> wrapper);
   	
}

