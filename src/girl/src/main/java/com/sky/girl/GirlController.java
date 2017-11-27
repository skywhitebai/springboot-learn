package com.sky.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Girl girlAdd(Girl girl){
        girl=girlRepository.save(girl);
        return girl;
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
}
