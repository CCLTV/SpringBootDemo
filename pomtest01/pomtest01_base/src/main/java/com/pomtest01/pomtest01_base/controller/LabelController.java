package com.pomtest01.pomtest01_base.controller;

import com.pomtest01.pomtest01_base.pojo.Label;
import com.pomtest01.pomtest01_base.service.LabelService;
import com.pomtest01.pomtest01_common.entity.PageResult;
import com.pomtest01.pomtest01_common.entity.Result;
import com.pomtest01.pomtest01_common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制层
 * */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    /**
     * 根据ID查询标签
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
    }

    /**
     * 增加标签
     * */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){

        labelService.add(label);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改标签
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Label label,@PathVariable String id){

        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除标签
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据条件查询
     * */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        //根据  label 参数（前台）传过来的条件进行查询
        List<Label> list = labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }
    /**
     * 条件+分页查询
     * */
    @RequestMapping(value="/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageData = labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }

}
