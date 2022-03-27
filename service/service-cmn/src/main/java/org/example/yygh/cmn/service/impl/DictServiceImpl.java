package org.example.yygh.cmn.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.yygh.cmn.mapper.DictMapper;
import org.example.yygh.cmn.service.DictService;
import org.example.yygh.model.cmn.Dict;
import org.springframework.stereotype.Service;

/**
 * @author 李聪燕
 * @date 2022/3/27 21:38
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    public List<Dict> findChildData(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<Dict>();
        queryWrapper.eq("parent_id", id);
        List<Dict> dicts = baseMapper.selectList(queryWrapper);
        for (Dict dict : dicts) {
            Long dictId = dict.getId();
            boolean isChild = this.isChildren(dictId);
            dict.setHasChildren(isChild);
        }
        return dicts;
    }

    public boolean isChildren(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<Dict>();
        queryWrapper.eq("parent_id", id);
        List<Dict> dicts = baseMapper.selectList(queryWrapper);
        return dicts.isEmpty() ? false : true;
    }
}
