package org.example.yygh.hosp.service.impl;

import java.util.Random;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.yygh.common.util.MD5;
import org.example.yygh.hosp.mapper.HospitalSetMapper;
import org.example.yygh.hosp.service.HospitalSetService;
import org.example.yygh.model.hosp.HospitalSet;
import org.example.yygh.vo.hosp.HospitalSetQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * @author 李聪燕
 * @date 2022/3/14 10:02
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Override
    public Page<HospitalSet> fingPageHospSet(long current, long limit, HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = new Page<>(current, limit);
        if (hospitalSetQueryVo == null) {
            Page<HospitalSet> hospitalSetPageNull = query().page(page);
            return hospitalSetPageNull;
        }
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        if (!StringUtils.isEmpty(hosname)) {
            wrapper.like("hosname", hospitalSetQueryVo.getHosname());
        }
        if (!StringUtils.isEmpty(hoscode)) {
            wrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());
        }
        Page<HospitalSet> hospitalSetPage = page(page, wrapper);
        return hospitalSetPage;
    }

    @Override
    public boolean saveHospSet(HospitalSet hospitalSet) {
        // 设置状态
        hospitalSet.setStatus(1);
        // 签名密钥
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()
         + "" + random.nextInt(1000)));
        boolean save = save(hospitalSet);
        return save;
    }


}
