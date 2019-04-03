package com.springboot.springbootjpa;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;
@Component
public class GetSsq {
    public static int[] get(){
        //准备红球和篮球号码数组
        //新建33个长度的int【】数组存到r
        int [] r=new int[33];
        //新建16个长度的int【】数组存到b
        int [] b=new int[16];
        //遍历r数组填入号码1到33
        for(int i=0;i<r.length;i++) {
            r[i]=i+1;
        }
        //遍历b数组填入号码1到16
        for(int i=0;i<b.length;i++) {
            b[i]=i+1;
        }
        //System.out.println(Arrays.toString(r));
        //System.out.println(Arrays.toString(b));
        //红球选择
        //新建6个长度的int【】数组存到red
        int [] red=new int[6];
        //新建33个长度的boolean【】数组存到flag
        boolean [] flag=new boolean[33];
        //i循环遍历red数组
        for(int i=0;i<red.length;i++) {
            int j;
            while (true) {
                //j随机定位到不重复位置
                j=new Random().nextInt(33);
                //如果j位置布尔值是false表示没选过
                if(flag[j]==false) {
                    break;
                }
            }
            //j位置值，放到i位置
            red[i]=r[j];
            flag[j]=true;//j位置标记为“已选”
        }
        //选择篮球、
        int blue=b[new Random().nextInt(16)];
        //Arrays.sort(red);
        red = Arrays.copyOf(red,red.length+1);
        red[red.length-1]=blue;
		/*System.out.println("红球"+Arrays.toString(red));
		System.out.println("蓝球"+blue);*/
        return red;
    }
}
