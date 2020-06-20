package com.soft1851.devoted.service.impl;

import com.soft1851.devoted.domain.entity.TComment;
import com.soft1851.devoted.mapper.TCommentMapper;
import com.soft1851.devoted.service.TCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
@Service
public class TCommentServiceImpl implements TCommentService {

    @Resource
    private TCommentMapper tCommentMapper;

    @Override
    public List<TComment> selectComment() {
        return tCommentMapper.selectComment();
    }

    @Override
    public List<TComment> selectById(Integer userId) {
        return tCommentMapper.selectById(userId);
    }

    @Override
    public void deleteById(Integer tbId) {
        tCommentMapper.deleteById(tbId);
    }

    @Override
    public void addComment(TComment tComment) {
        LocalDateTime dateTime = LocalDateTime.now();

        tComment.setGmtCreate(dateTime);
        tComment.setGmtModified(dateTime);

        tCommentMapper.addComment(tComment);
    }

    @Override
    public void updateComment(TComment tComment) {
        LocalDateTime dateTime = LocalDateTime.now();
        tComment.setGmtModified(dateTime);
        tCommentMapper.updateComment(tComment);
    }
}
