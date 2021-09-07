package com.webee.challenge.service;

import com.webee.challenge.model.Device;
import com.webee.challenge.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class DeviceServiceTest {

    private static Date date = new GregorianCalendar(2021, 01, 01).getTime();

    @SpyBean
    private DeviceService deviceService;

    @MockBean
    private DeviceRepository deviceRepository;

    @Test
    void addDevice() {
        // return deviceRepository.save(device);

        //given
        Device device = new Device();
        device.setId(10);
        device.setMac("010101010101");
        device.setTimestamp(date);
        given(deviceRepository.save(Mockito.any())).willReturn(device);
        //when
        Device deviceResult = deviceService.addDevice(device);
        //then
        assertEquals(10, deviceResult.getId());
        assertEquals("01:01:01:01:01:01", deviceResult.getMac());
        assertEquals(date, deviceResult.getTimestamp());

    }

    @Test
    void findDeviceByMAC() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findDeviceById() {
    }

    @Test
    void deleteDeviceById() {
    }
}