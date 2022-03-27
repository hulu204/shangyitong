package org.example.yygh.cmn.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.yygh.model.cmn.Dict;

/**
 * @author 李聪燕
 * @date 2022/3/27 21:37
 */
public interface DictService extends IService<Dict> {

    /**
     * 根据数据id查询子数据列表
     * @param id
     * @return
     */
    List<Dict> findChildData(Long id);

}
