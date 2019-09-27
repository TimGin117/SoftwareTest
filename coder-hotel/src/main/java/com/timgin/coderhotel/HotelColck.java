package com.timgin.coderhotel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HotelColck implements Observer {

    //时区ID
    private ZoneId zoneId;
    //时区偏移量
    private ZoneOffset zoneOffset;
    //时区名字
    private String zoneName;
    //时钟基准时间
    private LocalDateTime baseDateTime;
    //时钟逻辑偏移量起点
    private long startTime;
    //时钟逻辑偏移量终点
    private long endTime;
    //订阅手机时间
    private SmartPhone smartPhone;

    public HotelColck(SmartPhone smartPhone, ZoneOffset zoneOffset, ZoneId zoneId, String zoneName) {
        this.zoneOffset=zoneOffset;
        this.zoneId=zoneId;
        this.zoneName=zoneName;
        this.smartPhone=smartPhone;
        this.baseDateTime=smartPhone.getBaseDateTime();
        this.startTime=System.nanoTime();
        smartPhone.attach(this);
    }

    public void update() {
        this.baseDateTime=smartPhone.getBaseDateTime();
        startTime=System.nanoTime();
        display();
    }

    public void display() {
        endTime=System.nanoTime();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(baseDateTime.plusNanos(endTime-startTime),zoneOffset,zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(zoneName+"时间："+formatter.format(zonedDateTime));
    }

    public LocalDateTime getBaseDateTime() {
        return baseDateTime;
    }
}
