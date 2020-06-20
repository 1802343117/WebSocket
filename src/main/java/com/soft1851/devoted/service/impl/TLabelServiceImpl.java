package com.soft1851.devoted.service.impl;

import com.soft1851.devoted.domain.entity.TLabel;
import com.soft1851.devoted.mapper.TLabelMapper;
import com.soft1851.devoted.service.TLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 12559
 */
@Service
public class TLabelServiceImpl implements TLabelService {

    @Resource
    private TLabelMapper tLabelMapper;

    @Override
    public List<TLabel> selectLabel() {
        return tLabelMapper.selectLabel();
    }

    @Override
    public void deleteById(Integer tbId) {
        tLabelMapper.deleteById(tbId);
    }

    @Override
    public void addLabel(TLabel tLabel) {
        LocalDateTime dateTime = LocalDateTime.now();
        tLabel.setGmtCreate(dateTime);
        tLabel.setGmtModified(dateTime);
        tLabelMapper.addLabel(tLabel);
    }

    @Override
    public void updateById(TLabel tLabel) {
        LocalDateTime dateTime = LocalDateTime.now();
        tLabel.setGmtModified(dateTime);
        tLabelMapper.updateById(tLabel);
    }
}
