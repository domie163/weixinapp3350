package com.dao;

import com.entity.ZufangzhangdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZufangzhangdanVO;
import com.entity.view.ZufangzhangdanView;


/**
 * 租房账单
 * 
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface ZufangzhangdanDao extends BaseMapper<ZufangzhangdanEntity> {
	
	List<ZufangzhangdanVO> selectListVO(@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);
	
	ZufangzhangdanVO selectVO(@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);
	
	List<ZufangzhangdanView> selectListView(@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);

	List<ZufangzhangdanView> selectListView(Pagination page,@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);
	
	ZufangzhangdanView selectView(@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);
	
}
