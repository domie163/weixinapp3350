package com.dao;

import com.entity.FangyuanguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuanguanliVO;
import com.entity.view.FangyuanguanliView;


/**
 * 房源管理
 * 
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface FangyuanguanliDao extends BaseMapper<FangyuanguanliEntity> {
	
	List<FangyuanguanliVO> selectListVO(@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);
	
	FangyuanguanliVO selectVO(@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);
	
	List<FangyuanguanliView> selectListView(@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);

	List<FangyuanguanliView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);
	
	FangyuanguanliView selectView(@Param("ew") Wrapper<FangyuanguanliEntity> wrapper);
	
}
