package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZufangdingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZufangdingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangdingdanView;


/**
 * 租房订单
 *
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface ZufangdingdanService extends IService<ZufangdingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZufangdingdanVO> selectListVO(Wrapper<ZufangdingdanEntity> wrapper);
   	
   	ZufangdingdanVO selectVO(@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);
   	
   	List<ZufangdingdanView> selectListView(Wrapper<ZufangdingdanEntity> wrapper);
   	
   	ZufangdingdanView selectView(@Param("ew") Wrapper<ZufangdingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZufangdingdanEntity> wrapper);
   	
}

