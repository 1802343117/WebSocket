package com.soft1851.devoted.controller;

import com.soft1851.devoted.domain.entity.TComment;
import com.soft1851.devoted.service.TCommentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/api/comment")
@Slf4j
public class TCommentController {

    @Resource
    private TCommentService tCommentService;

    /**
     * 查询所有留言
     *
     * @return List<TComment>
     */
    @GetMapping("/selectComment")
    public List selectComment() {
        return tCommentService.selectComment();
    }

    /**
     * 根据ID查询留言
     *
     * @param userId
     * @return TComment
     */
    @GetMapping("/selectById")
    public List<TComment> selectById(@Param("userId") Integer userId) {
        return tCommentService.selectById(userId);
    }

    /**
     * 根据ID删除留言
     *
     * @param tbId
     */
    @DeleteMapping("/delete")
    void delete(@Param("userId") Integer tbId) {
        tCommentService.deleteById(tbId);
    }

    /**
     * 添加留言
     *
     * @param tComment
     */
    @PostMapping("/addComment")
    void addComment(@RequestBody TComment tComment) {
        tCommentService.addComment(tComment);
    }

    @PutMapping("/updateComment")
    void updateComment(@RequestBody TComment tComment) {
        tCommentService.updateComment(tComment);
    }

}
