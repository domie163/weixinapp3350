package com.dao;

import com.entity.ZufangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZufangxinxiVO;
import com.entity.view.ZufangxinxiView;


/**
 * 租房信息
 * 
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface ZufangxinxiDao extends BaseMapper<ZufangxinxiEntity> {
	
	List<ZufangxinxiVO> selectListVO(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
	
	ZufangxinxiVO selectVO(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
	
	List<ZufangxinxiView> selectListView(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);

	List<ZufangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
	
	ZufangxinxiView selectView(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
	
}
