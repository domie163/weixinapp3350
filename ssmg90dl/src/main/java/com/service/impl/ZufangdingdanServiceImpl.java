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


import com.dao.ZufangdingdanDao;
import com.entity.ZufangdingdanEntity;
import com.service.ZufangdingdanService;
import com.entity.vo.ZufangdingdanVO;
import com.entity.view.ZufangdingdanView;

@Service("zufangdingdanService")
public class ZufangdingdanServiceImpl extends ServiceImpl<ZufangdingdanDao, ZufangdingdanEntity> implements ZufangdingdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZufangdingdanEntity> page = this.selectPage(
                new Query<ZufangdingdanEntity>(params).getPage(),
                new EntityWrapper<ZufangdingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZufangdingdanEntity> wrapper) {
		  Page<ZufangdingdanView> page =new Query<ZufangdingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZufangdingdanVO> selectListVO(Wrapper<ZufangdingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZufangdingdanVO selectVO(Wrapper<ZufangdingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZufangdingdanView> selectListView(Wrapper<ZufangdingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZufangdingdanView selectView(Wrapper<ZufangdingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
