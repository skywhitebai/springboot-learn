package com.sky.girl.service;

import com.sky.girl.domain.Girl;
import com.sky.girl.enums.ResultEnum;
import com.sky.girl.exception.GirlException;
import com.sky.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setAge(18);
        girlA.setCupSize("F");
        girlRepository.save(girlA);


        Girl girlB=new Girl();
        girlB.setAge(20);
        girlB.setCupSize("FFFF");
        girlRepository.save(girlB);
    }


    public void getAge(Integer id) throws Exception {
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){

            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        else if(age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
