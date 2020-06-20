package com.soft1851.devoted.service;

import com.soft1851.devoted.domain.entity.TComment;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
public interface TCommentService {

    /**
     * 查询所有
     *
     * @return List<TComment>
     */
    List<TComment> selectComment();

    /**
     * 根据ID查询
     *
     * @param userId
     * @return List<TComment>
     */
    List<TComment> selectById(Integer userId);

    /**
     * 根据ID删除
     *
     * @param tbId
     */
    void deleteById(Integer tbId);

    /**
     * 添加留言
     *
     * @param tComment
     */
    void addComment(TComment tComment);

    /**
     * 修改留言
     *
     * @param tComment
     */
    void updateComment(TComment tComment);
}
