package com.timgin.coderhotel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SmartPhone implements Subject {

    private static final ZoneId ZONE_ID=ZoneId.of("UTC+8");
    private static final ZoneOffset ZONE_OFFSET=ZoneOffset.ofHours(8);

    private List<Observer> observerList=new ArrayList<>();
    private LocalDateTime baseDateTime;
    private Long startTime;
    private Long endTime;

    public SmartPhone(LocalDateTime localDateTime) {
        setBaseDateTime(localDateTime);
    }

    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    public void detach(Observer observer) {
        this.observerList.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observerList) {
             observer.update();
        }
    }

    public LocalDateTime getBaseDateTime() {
        return baseDateTime;
    }


    public void setBaseDateTime(LocalDateTime baseDateTime) {
        this.baseDateTime = baseDateTime;
        startTime=System.nanoTime();
    }
    public void modifyBaseDateTime(LocalDateTime baseDateTime){
        this.setBaseDateTime(baseDateTime);
        display();
        notifyObservers();
    }
    public void modifyBaseDateTime(int year, int month, int dayOfMonth, int hour, int minute, int second){
        this.setBaseDateTime(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
        display();
        notifyObservers();
    }

    public void display(){
        endTime=System.nanoTime();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(baseDateTime.plusNanos(endTime-startTime),ZONE_OFFSET,ZONE_ID);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println("大堂服务员手机时间(北京时间)："+formatter.format(zonedDateTime1));
    }

}
