package com.soft1851.devoted.mapper;

import com.soft1851.devoted.domain.entity.TMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
public interface TMenuMapper {

    /**
     * 根据ID查询
     * @param menuId
     * @return
     */
    @Select("SELECT * FROM t_menu WHERE menu_id=#{menuId}")
    List<TMenu> selectById(Integer menuId);

}
