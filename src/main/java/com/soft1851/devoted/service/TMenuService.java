package com.soft1851.devoted.service;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
public interface TMenuService {

    /**
     * 根据ID查询
     * @param menuId
     * @return
     */
    Map<String, Object> selectById(Integer menuId);

}
