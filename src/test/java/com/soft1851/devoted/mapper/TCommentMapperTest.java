//package com.soft1851.devoted.mapper;
//
//import com.soft1851.devoted.domain.entity.TComment;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//
//@SpringBootTest
//class TCommentMapperTest {
//
//    @Resource
//    private TCommentMapper tCommentMapper;
//
//    @Test
//    void selectComment() {
//        System.out.println(tCommentMapper.selectById(1));
//    }
//
//    @Test
//    void updateComment() {
//        TComment tComment = new TComment();
//        tComment.setUserId(10);
//        tComment.setContent("修改");
//        tComment.setDeleteFlag(true);
//        LocalDateTime today = LocalDateTime.now();
//        System.out.println(today);
//        tComment.setGmtModified(today);
//        tCommentMapper.updateComment(tComment);
//    }
//
//}