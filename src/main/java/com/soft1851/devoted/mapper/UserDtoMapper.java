package com.soft1851.devoted.mapper;

import com.soft1851.devoted.domain.dto.UserDto;
import org.apache.ibatis.annotations.Select;

/**
 * @author 12559
 */
public interface UserDtoMapper {

    @Select("SELECT a.*,b.role_name,b.role_decoration,c.menu_id\n" +
            "FROM t_user a INNER JOIN t_role b ON\n" +
            "a.role_id = b.role_id\n" +
            "INNER JOIN t_role_menu c ON\n" +
            "b.role_id = c.role_id WHERE a.user_id=#{userId}")
   UserDto userJoint(Integer userId);
}
