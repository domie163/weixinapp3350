package com.dao;

import com.entity.ZufangdingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZufangdingdanVO;
import com.entity.view.ZufangdingdanView;


/**
 * 租房订单
 * 
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface ZufangdingdanDao extends BaseMapper<ZufangdingdanEntity> {
	
	List<ZufangdingdanVO> selectListVO(@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);
	
	ZufangdingdanVO selectVO(@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);
	
	List<ZufangdingdanView> selectListView(@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);

	List<ZufangdingdanView> selectListView(Pagination page,@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);
	
	ZufangdingdanView selectView(@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);
	
}
