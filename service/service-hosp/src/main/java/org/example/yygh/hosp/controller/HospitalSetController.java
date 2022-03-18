package org.example.yygh.hosp.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.yygh.hosp.model.hosp.HospitalSet;
import org.example.yygh.hosp.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李聪燕
 * @date 2022/3/14 10:06
 */
@Api("医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation("查询所有医院")
    @GetMapping("/all")
    public ResponseEntity<List<HospitalSet>> findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return ResponseEntity.ok(list);

    }

    @ApiOperation("逻辑删除")
    @DeleteMapping("/{id}")
    public boolean delById(@PathVariable("id") Integer id) {
        boolean b = hospitalSetService.removeById(id);
        return b;
    }




}
