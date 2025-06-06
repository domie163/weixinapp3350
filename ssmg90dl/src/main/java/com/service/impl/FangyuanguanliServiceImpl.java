package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FangyuanguanliDao;
import com.entity.FangyuanguanliEntity;
import com.service.FangyuanguanliService;
import com.entity.vo.FangyuanguanliVO;
import com.entity.view.FangyuanguanliView;

@Service("fangyuanguanliService")
public class FangyuanguanliServiceImpl extends ServiceImpl<FangyuanguanliDao, FangyuanguanliEntity> implements FangyuanguanliService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuanguanliEntity> page = this.selectPage(
                new Query<FangyuanguanliEntity>(params).getPage(),
                new EntityWrapper<FangyuanguanliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangyuanguanliEntity> wrapper) {
		  Page<FangyuanguanliView> page =new Query<FangyuanguanliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FangyuanguanliVO> selectListVO(Wrapper<FangyuanguanliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangyuanguanliVO selectVO(Wrapper<FangyuanguanliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangyuanguanliView> selectListView(Wrapper<FangyuanguanliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuanguanliView selectView(Wrapper<FangyuanguanliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
