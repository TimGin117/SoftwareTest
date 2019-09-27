package com.timgin.coderhotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class HotelColckTest {

    @Test
    public void updateTest(){

        SmartPhone smartPhone=new SmartPhone(LocalDateTime.now());

        ZoneId zoneId=ZoneId.of("UTC");
        ZoneOffset zoneOffset=ZoneOffset.ofHours(8);
        String zoneName="London";

        HotelColck hotelColck=new HotelColck(smartPhone,zoneOffset,zoneId,zoneName);

        LocalDateTime baseDateTime=LocalDateTime.now();
        smartPhone.setBaseDateTime(baseDateTime);

        hotelColck.update();

        assertEquals(baseDateTime,hotelColck.getBaseDateTime());

    }


}
