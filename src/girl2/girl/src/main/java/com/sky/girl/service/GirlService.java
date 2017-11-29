package com.sky.girl.service;

import com.sky.girl.domain.Girl;
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
}
