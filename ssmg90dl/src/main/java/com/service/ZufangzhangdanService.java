package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZufangzhangdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZufangzhangdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangzhangdanView;


/**
 * 租房账单
 *
 * @author 
 * @email 
 * @date 2021-04-19 17:47:04
 */
public interface ZufangzhangdanService extends IService<ZufangzhangdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZufangzhangdanVO> selectListVO(Wrapper<ZufangzhangdanEntity> wrapper);
   	
   	ZufangzhangdanVO selectVO(@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);
   	
   	List<ZufangzhangdanView> selectListView(Wrapper<ZufangzhangdanEntity> wrapper);
   	
   	ZufangzhangdanView selectView(@Param("ew") Wrapper<ZufangzhangdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZufangzhangdanEntity> wrapper);
   	
}

