package org.example.yygh.hosp.controller;

import java.util.List;

import org.example.yygh.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.yygh.hosp.service.HospitalSetService;
import org.example.yygh.model.hosp.HospitalSet;
import org.example.yygh.vo.hosp.HospitalSetQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李聪燕
 * @date 2022/3/14 10:06
 */
@Api("医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@CrossOrigin
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation("查询所有医院")
    @GetMapping("/all")
    public Result findAllHospSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }

    @ApiOperation("逻辑删除")
    @DeleteMapping("/delHospSet/{id}")
    public Result delByIdHospSet(@PathVariable("id") Integer id) {
        boolean b = hospitalSetService.removeById(id);
        return b ? Result.ok() : Result.fail();
    }

    @ApiOperation("分页查询")
    @PostMapping("/findPageHospSet/{current}/{limit}")
    public Result fingPageHospSet(@PathVariable("current") long current,
                                  @PathVariable("limit") long limit,
                                  @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {
        return Result.ok(hospitalSetService.fingPageHospSet(current, limit, hospitalSetQueryVo));
    }

    @ApiOperation("添加医院设置")
    @PostMapping("/saveHospitalSet")
    public Result saveHospSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.saveHospSet(hospitalSet);
        return flag ? Result.ok() : Result.fail();
    }

    @ApiOperation("根据id获取医院设置")
    @GetMapping("/getHospSet/{id}")
    public Result getHospSetById(@PathVariable("id") long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    @ApiOperation("修改医院设置")
    @PutMapping("/updateHospSet/{id}")
    public Result updateHospSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        return flag ? Result.ok() : Result.fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchDelHospSet")
    public Result batchDelHospSet(@RequestBody List<Long> ids) {
        boolean flag = hospitalSetService.removeByIds(ids);
        return flag ? Result.ok() : Result.fail();
    }

    @ApiOperation("状态更改")
    @PutMapping("/lockHospSet/{id}/{status}")
    public Result lockHospSet(@PathVariable("id")long id,
                              @PathVariable("status")Integer status) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        hospitalSet.setStatus(status);
        hospitalSetService.updateById(hospitalSet);
        return Result.ok();
    }

}
