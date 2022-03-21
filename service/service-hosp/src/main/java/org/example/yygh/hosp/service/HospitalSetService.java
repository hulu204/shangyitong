package org.example.yygh.hosp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.yygh.model.hosp.HospitalSet;
import org.example.yygh.vo.hosp.HospitalSetQueryVo;

/**
 * @author 李聪燕
 * @date 2022/3/14 9:45
 */
public interface HospitalSetService extends IService<HospitalSet> {
    /**
     * 分页查找
     * @param current
     * @param limit
     * @param hospitalSetQueryVo
     * @return
     */
    public Page<HospitalSet> fingPageHospSet(long current, long limit, HospitalSetQueryVo hospitalSetQueryVo);

    /**
     * 添加医院设置
     * @param hospitalSet
     * @return
     */
    public boolean saveHospSet(HospitalSet hospitalSet);

}
