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


import com.dao.ZufangzhangdanDao;
import com.entity.ZufangzhangdanEntity;
import com.service.ZufangzhangdanService;
import com.entity.vo.ZufangzhangdanVO;
import com.entity.view.ZufangzhangdanView;

@Service("zufangzhangdanService")
public class ZufangzhangdanServiceImpl extends ServiceImpl<ZufangzhangdanDao, ZufangzhangdanEntity> implements ZufangzhangdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZufangzhangdanEntity> page = this.selectPage(
                new Query<ZufangzhangdanEntity>(params).getPage(),
                new EntityWrapper<ZufangzhangdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZufangzhangdanEntity> wrapper) {
		  Page<ZufangzhangdanView> page =new Query<ZufangzhangdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZufangzhangdanVO> selectListVO(Wrapper<ZufangzhangdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZufangzhangdanVO selectVO(Wrapper<ZufangzhangdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZufangzhangdanView> selectListView(Wrapper<ZufangzhangdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZufangzhangdanView selectView(Wrapper<ZufangzhangdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
