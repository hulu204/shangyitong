package org.example.yygh.cmn.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.yygh.cmn.service.DictService;
import org.example.yygh.common.result.Result;
import org.example.yygh.model.cmn.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李聪燕
 * @date 2022/3/27 21:33
 */
@Api("数据字典api")
@RestController
@CrossOrigin
@RequestMapping("/admin/cmn/dict")
public class DictController {

    @Autowired
    DictService dictService;

    @ApiOperation("查找子节点")
    @GetMapping("/findChild/{id}")
    public Result<List<Dict>> findChildData (@PathVariable("id") Long id) {
        List<Dict> childData = dictService.findChildData(id);
        return Result.ok(childData);
    }
}
