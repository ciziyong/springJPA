package com.springboot.springbootjpa.controller;

import com.springboot.springbootjpa.GetSsq;
import com.springboot.springbootjpa.mapper.SsqMapper;
import com.springboot.springbootjpa.model.Ssq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SsqController {
    @Autowired
    private  SsqMapper ssqMapper;
    @RequestMapping(value = "/getOne")
    public String getOKssq(){
       int[] ints =  GetSsq.get();
       return "红球: "+ints[0]+"   "+ints[1]+"   "+ints[2]+"   "+ints[3]+"   "+ints[4]+"   "+ints[5]+"   篮球: "+ints[6];
    }

    @RequestMapping(value = "/add")
    public void theWinning(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
         cachedThreadPool.execute( new Runnable(){
                @Override
                public void run() {
                    List<Ssq> ssqSet = new ArrayList<>();
                    for(int i=0;i<500;i++){
                        ssqSet.clear();
                        for (int j=0;j<200;j++) {
                            Ssq ssq = new Ssq();
                            int[] ints =  GetSsq.get();
                            ssq.setRed1(ints[0]);
                            ssq.setRed2(ints[1]);
                            ssq.setRed3(ints[2]);
                            ssq.setRed4(ints[3]);
                            ssq.setRed5(ints[4]);
                            ssq.setRed6(ints[5]);
                            ssq.setBlue(ints[6]);
                            ssqSet.add(ssq);
                        }
                        ssqMapper.saveAll(ssqSet);
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
