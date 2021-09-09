package com.webee.challenge.model;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeviceHelper {

    public static final Integer ID = 1;
    public static final Date DATE_BORDER_UP = new GregorianCalendar(2021, 01, 01).getTime();
    public static final Date DATE_BORDER = new GregorianCalendar(2020, 01, 01).getTime();
    public static final Date DATE_BORDER_DOWN = new GregorianCalendar(2019, 12, 31).getTime();
    public static final String MAC_ADDRESS_OK = "01:01:01:01:01:01";
    public static final String MAC_ADDRESS_NOOK = "010101010101";
    public static final String JSON_RESPONSE = "\"id\":1,\"mac\":\"01:01:01:01:01:01\",\"timestamp\":\"01022021\"";
    public static final String JSON_BODY = "{\"mac\":\"01:01:01:01:01:01\",\"timestamp\":\"01022021\"}";
    public static final String JSON_BODY_BAD_MAC = "{\"mac\":\"010101010101\",\"timestamp\":\"01022021\"}";
    public static final String JSON_BODY_BAD_DATE = "{\"mac\":\"01:01:01:01:01:01\",\"timestamp\":\"31122019\"}";

    public static Device getDeviceOk(){
        return new Device(ID, MAC_ADDRESS_OK, DATE_BORDER_UP);
    }

    public static Device getDeviceMacAddressNoOk(){
        return new Device(ID, MAC_ADDRESS_NOOK, DATE_BORDER_UP);
    }

    public static Device getDeviceBorder(){
        return new Device(ID, MAC_ADDRESS_OK, DATE_BORDER);
    }

    public static Device getDeviceBorderDown(){
        return new Device(ID, MAC_ADDRESS_OK, DATE_BORDER_DOWN);
    }

    public static void checkDevice(Device deviceExpected, Device deviceResult){
        assertEquals(deviceExpected.getId(), deviceResult.getId());
        assertEquals(deviceExpected.getMac(), deviceResult.getMac());
        assertEquals(deviceExpected.getTimestamp(), deviceResult.getTimestamp());
    }

}
