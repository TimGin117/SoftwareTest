package com.timgin.coderhotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartPhoneTest {


    @Test
    public void notifyObserversTest(){

        SmartPhone smartPhone=new SmartPhone(LocalDateTime.now());
        ZoneId zoneId=ZoneId.of("UTC");
        ZoneOffset zoneOffset=ZoneOffset.ofHours(8);
        String zoneName="London";

        HotelColck hotelColck=new HotelColck(smartPhone,zoneOffset,zoneId,zoneName);

        smartPhone.notifyObservers();
        assertEquals(smartPhone.getBaseDateTime(),hotelColck.getBaseDateTime());
    }

    @Test
    public void modifyBaseDateTimeTest1(){

        SmartPhone smartPhone=new SmartPhone(LocalDateTime.now());

        LocalDateTime baseDateTime=LocalDateTime.now();
        smartPhone.modifyBaseDateTime(baseDateTime);

        assertEquals(baseDateTime,smartPhone.getBaseDateTime());

    }

    @Test
    public void modifyBaseDateTimeTest2(){

        SmartPhone smartPhone=new SmartPhone(LocalDateTime.now());

        LocalDateTime baseDateTime=LocalDateTime.now();
        smartPhone.modifyBaseDateTime(2019,9,12,11,20,22);

        assertEquals(LocalDateTime.of(2019,9,12,11,20,22),smartPhone.getBaseDateTime());

    }
}
