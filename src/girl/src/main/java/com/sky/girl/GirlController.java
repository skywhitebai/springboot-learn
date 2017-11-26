package com.sky.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> girlList(){
        List<Girl> list=girlRepository.findAll();
        return list;
    }
}
