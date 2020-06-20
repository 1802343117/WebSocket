package com.soft1851.devoted.mapper;

import com.soft1851.devoted.domain.entity.TComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
public interface TCommentMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("SELECT * FROM t_comment")
    List<TComment> selectComment();

    /**
     * 根据ID查询
     *
     * @param userId
     * @return
     */
    @Select("SELECT * FROM t_comment WHERE user_id=#{userId}")
    List<TComment> selectById(Integer userId);

    /**
     * 根据ID删除
     *
     * @param tbId
     */
    @Delete("DELETE FROM t_comment WHERE tb_id=#{tbId}")
    void deleteById(Integer tbId);

    /**
     * 添加留言
     */
    @Insert("INSERT INTO t_comment(user_id, content, delete_flag, gmt_create, gmt_modified)VALUES(#{userId},#{content},#{deleteFlag},#{gmtCreate},#{gmtModified})")
    void addComment(TComment tComment);

    /**
     * 根据ID修改留言
     */
    @Update("UPDATE t_comment SET content=#{content}, delete_flag=#{deleteFlag}, gmt_modified=#{gmtModified} WHERE tb_id=#{tbId}")
    void updateComment(TComment tComment);

}
