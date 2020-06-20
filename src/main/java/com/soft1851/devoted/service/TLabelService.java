package com.soft1851.devoted.service;

import com.soft1851.devoted.domain.entity.TLabel;

import java.util.List;

public interface TLabelService {

    /**
     * 查询所有
     */
    List<TLabel> selectLabel();

    /**
     * 根据ID删除
     *
     * @param tbId
     */
    void deleteById(Integer tbId);

    /**
     * 添加留言
     *
     * @param tLabel
     */
    void addLabel(TLabel tLabel);

    /**
     * 修改留言
     *
     * @param tLabel
     */
    void updateById(TLabel tLabel);
}
