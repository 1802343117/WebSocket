package com.soft1851.devoted.service.impl;

import com.soft1851.devoted.common.ResultCode;
import com.soft1851.devoted.domain.entity.TMenu;
import com.soft1851.devoted.exception.CustomException;
import com.soft1851.devoted.mapper.TMenuMapper;
import com.soft1851.devoted.service.TMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
@Service
public class TMenuServiceImpl implements TMenuService {

    @Resource
    private TMenuMapper tMenuMapper;

    @Override
    public Map<String, Object> selectById(Integer menuId) {
        List<TMenu> tMenus = tMenuMapper.selectById(menuId);
        Map<String, Object> map = new TreeMap<>();
        // 判断查询结果是否为 null
        if (tMenus != null) {
            // 查询结果不为null时, 将需要的数据存入 Map
            for (int i = 0; i < tMenus.size(); i++) {
                map.put(tMenus.get(i).getMenuName(), tMenus.get(i).getPath());
            }
        } else {
            System.out.println("没有相关内容，请核对输入信息");
            map.put("msg", "数据未找到");
            throw new CustomException("数据未找到", ResultCode.USER_NOT_FOUND);
        }
        return map;
    }
}
