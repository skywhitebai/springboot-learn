package com.sky.girl.controller;

import com.sky.girl.domain.Girl;
import com.sky.girl.domain.Result;
import com.sky.girl.repository.GirlRepository;
import com.sky.girl.service.GirlService;
import com.sky.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    GirlService girlService;
    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        List<Girl> list=girlRepository.findAll();
        return list;
    }

    /**
     * 添加女生数据
     * @param girl
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.erro(0,bindingResult.getFieldError().getDefaultMessage());
        }
        girl=girlRepository.save(girl);
        return ResultUtil.success(girl);
    }
    //获取某个女生数据
    @GetMapping("/girls/{id}")
    public Girl girlList(@PathVariable("id") Integer id){
        Girl girl=girlRepository.getOne(id);
       return  girl;
    }
    //修改某个女生数据
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(Girl girl){
        girl=girlRepository.save(girl);
        return  girl;
    }

    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
       girlRepository.delete(id);
    }

    /**
     * 通过年龄查询所有女生列表
     * @return
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        List<Girl> list=girlRepository.findByAge(age);
        return list;
    }

    /**
     * 插入两个数据
     * @return
     */
    @PutMapping("/girls/insertTwo")
    public void girlInsertTwo(){
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
