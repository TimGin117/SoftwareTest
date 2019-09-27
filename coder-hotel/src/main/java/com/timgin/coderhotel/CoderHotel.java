package com.timgin.coderhotel;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Scanner;

public class CoderHotel {

    private static SmartPhone smartPhone=new SmartPhone(LocalDateTime.now());
    private static HotelColck BeijingClock=new HotelColck(smartPhone, ZoneOffset.ofHours(8), ZoneId.of("UTC+8"),"北京");
    private static HotelColck LondonClock=new HotelColck(smartPhone,ZoneOffset.ofHours(8), ZoneId.of("UTC"),"伦敦");
    private static HotelColck MoscowClock=new HotelColck(smartPhone,ZoneOffset.ofHours(8), ZoneId.of("UTC+4"),"莫斯科");
    private static HotelColck SydneyClock=new HotelColck(smartPhone,ZoneOffset.ofHours(8), ZoneId.of("UTC+10"),"悉尼");
    private static HotelColck NewYorkClock=new HotelColck(smartPhone,ZoneOffset.ofHours(8), ZoneId.of("UTC-4"),"纽约");

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        displayMenu();

        while(true){

            String enter=in.next();

            switch (enter.toLowerCase()){
                case "a":
                    BeijingClock.display();
                    LondonClock.display();
                    MoscowClock.display();
                    SydneyClock.display();
                    NewYorkClock.display();
                    break;
                case "b":
                    smartPhone.display();
                    break;
                case "c":
                    System.out.println("自动校准至当前时间......");
                    smartPhone.modifyBaseDateTime(LocalDateTime.now());
                    break;
                case "d":
                    System.out.println("手动设置时间 'year month day hour minute second'   (eg: '2019 9 20 11 12 12')");
                    try {
                        smartPhone.modifyBaseDateTime(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
                    } catch (Exception e) {
                        System.err.println("参数设置错误");
                    }
                    break;
                case "q":
                    System.out.println("------------------Bye!Bye!------------------------");
                    return;
                default:
                    System.err.println("操作无效");
                    break;
            }
        }
    }

    public static void displayMenu(){
        System.out.println("------------------Welcome to Coder Hotel------------------");
        System.out.println("输入下列选项完成相应操作：");
        System.out.println(" a : 显示酒店5个时钟的时间");
        System.out.println(" b : 显示大堂服务员的手机时间");
        System.out.println(" c : 用当前时间校正时钟");
        System.out.println(" d : 用自定义时间校正时钟");
        System.out.println(" q : 退出");
    }
}
