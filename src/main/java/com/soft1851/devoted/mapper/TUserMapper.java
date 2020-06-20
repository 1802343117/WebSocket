package com.soft1851.devoted.mapper;

import com.soft1851.devoted.domain.dto.LoginDto;
import com.soft1851.devoted.domain.entity.TUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hjl
 * @since 2020-06-10
 */
@Repository
public interface TUserMapper {

    /**
     * 查询所有用户信息
     *
     * @return List<TUser>
     */
    @Select("SELECT * FROM t_user")
    List<TUser> selectUser();

    /**
     * 用户登录
     *
     * @param account
     * @return
     */
    @Select("SELECT * FROM t_user WHERE account=#{account}")
    LoginDto userLogin(String account);

    /**
     * 添加用户
     *
     * @param tUser
     */
    @Insert("INSERT INTO t_user(user_id,account,avatar,delete_flag,gmt_create," +
            "gmt_modified,password,role_id,salt,status,user_gender,user_name,user_path,user_phone)VALUES(#{userId}," +
            "#{account},#{avatar},#{deleteFlag},#{gmtCreate},#{gmtModified},#{password},#{roleId},#{salt},#{status},#{userGender}," +
            "#{userName},#{userPath},#{userPhone})")
    void addUser(TUser tUser);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Delete("DELETE FROM t_user WHERE user_id=#{userId}")
    Integer deleteByIdUser(Integer id);

    /**
     * 修改用户信息  根据user_id=#{userId}修改用户信息
     *
     * @param tUser role_id=#{roleId},不修改
     */
    @Update("UPDATE t_user SET account=#{account},delete_flag=#{deleteFlag}," +
            "gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},password=#{password}," +
            "salt=#{salt},status=#{status},user_gender=#{userGender}," +
            "user_name=#{userName},user_path=#{userPath},user_phone=#{userPhone} WHERE user_id=#{userId}")
    void updateUser(TUser tUser);

    @Select("SELECT * FROM t_user WHERE account=#{account}")
    LoginDto findByAccount(@Param("account") String account);

    @Select("SELECT * FROM t_user WHERE user_id=#{userId}")
    LoginDto findUserById(@Param("userId") String userId);

    /**
     * 通过用户ID查看用户信息
     * @param userId
     * @return
     */
    @Select("SELECT * FROM t_user WHERE user_id=#{userId}")
    TUser selectById(@Param("userId") int userId);

    /**
     * 修改用户通信接口信息
     * user_path 通信地址
     * status 接入状态
     * @param tUser
     */
    @Update("UPDATE t_user SET user_path=#{userPath}, status=#{status} WHERE user_id=#{userId}")
    void updateUserPath(TUser tUser);

    /**
     * 固定查询
     * 查看用户表中
     * 角色为：服务人员
     * 用户状态为：空闲
     * 登录情况不为：null
     * @return TUser
     */
    @Select("SELECT * FROM t_user WHERE role_id=2 && `status`=0 && user_path != null")
    List<TUser> selectRsu();

}
