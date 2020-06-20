//package com.soft1851.devoted.service;
//
//import com.soft1851.devoted.domain.entity.TComment;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//
//@SpringBootTest
//class TCommentServiceTest {
//
//    @Resource
//    private TCommentService tCommentService;
//
//    @Test
//    void selectComment() {
//        System.out.println(tCommentService.selectComment());
//    }
//
//    @Test
//    void selectById() {
//        System.out.println(tCommentService.selectById(1));
//    }
//
//    @Test
//    void deleteById() {
//        tCommentService.deleteById(12);
//    }
//
//    @Test
//    void addComment() {
//        TComment tComment = new TComment();
//        tComment.setUserId(1);
//        tComment.setContent("测试添加数据");
//        tComment.setDeleteFlag(true);
//        tCommentService.addComment(tComment);
//    }
//
//    @Test
//    void updateComment() {
//        TComment tComment = new TComment();
//        tComment.setTbId(1);
//        tComment.setContent("修改这条数据");
//        tComment.setDeleteFlag(true);
//        tCommentService.updateComment(tComment);
//    }
//}