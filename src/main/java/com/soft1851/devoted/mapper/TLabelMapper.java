package com.soft1851.devoted.mapper;

import com.soft1851.devoted.domain.entity.TLabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 12559
 */
public interface TLabelMapper {

    /**
     * 查询所有
     */
    @Select("SELECT * FROM t_label")
    List<TLabel> selectLabel();

    /**
     * 根据ID删除
     */
    @Delete("DELETE FROM t_label WHERE tb_id=#{tbId}")
    void deleteById(Integer tbId);

    /**
     * 添加留言
     */
    @Insert("INSERT INTO t_label (label_content, delete_flag, gmt_create, gmt_modified) VALUES (#{labelContent}, #{deleteFlag}, #{gmtCreate}, #{gmtModified})")
    void addLabel(TLabel tLabel);

    /**
     * 根据ID修改标签
     */
    @Update("UPDATE t_label SET label_content=#{labelContent}, delete_flag=#{deleteFlag}, gmt_modified=#{gmtModified} WHERE tb_id=#{tbId}")
    void updateById(TLabel tLabel);
}
