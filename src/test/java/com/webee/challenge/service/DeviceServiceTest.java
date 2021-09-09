package com.webee.challenge.service;

import com.webee.challenge.model.Device;
import com.webee.challenge.model.DeviceHelper;
import com.webee.challenge.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class DeviceServiceTest {

    @SpyBean
    private DeviceService deviceService;

    @MockBean
    private DeviceRepository deviceRepository;

    @Test
    void addDevice() {
        //given
        given(deviceRepository.save(Mockito.any())).willReturn(DeviceHelper.getDeviceOk());
        //when
        Device deviceResult = deviceService.addDevice(DeviceHelper.getDeviceOk());
        //then
        DeviceHelper.checkDevice(DeviceHelper.getDeviceOk(), deviceResult);
    }

    @Test
    void findDeviceByMAC() {
        //given
        given(deviceRepository.findBymac(DeviceHelper.MAC_ADDRESS_OK)).willReturn(DeviceHelper.getDeviceOk());
        given(deviceRepository.findBymac(DeviceHelper.MAC_ADDRESS_NOOK)).willReturn(null);
        //when
        Device deviceResult = deviceService.findDeviceByMAC(DeviceHelper.MAC_ADDRESS_OK);
        Device deviceResult2 = deviceService.findDeviceByMAC(DeviceHelper.MAC_ADDRESS_NOOK);
        //then
        DeviceHelper.checkDevice(DeviceHelper.getDeviceOk(), deviceResult);
        assertTrue(deviceResult2 == null);
    }

    @Test
    void findAll() {
        //given
        given(deviceRepository.findAll()).willReturn(Arrays.asList(DeviceHelper.getDeviceOk(), DeviceHelper.getDeviceBorder()));
        //when
        List<Device> deviceResult = deviceService.findAll();
        //then
        DeviceHelper.checkDevice(DeviceHelper.getDeviceOk(), deviceResult.get(0));
        DeviceHelper.checkDevice(DeviceHelper.getDeviceBorder(), deviceResult.get(1));
    }

    @Test
    void findDeviceById() {
        //given
        given(deviceRepository.findById(DeviceHelper.ID)).willReturn(Optional.of(DeviceHelper.getDeviceOk()));
        given(deviceRepository.findById(2)).willReturn(Optional.empty());
        //when
        Optional<Device> deviceResult = deviceService.findDeviceById(DeviceHelper.ID);
        Optional<Device> deviceResult2 = deviceService.findDeviceById(2);
        //then
        DeviceHelper.checkDevice(DeviceHelper.getDeviceOk(), deviceResult.get());
        assertTrue(deviceResult2.isEmpty());
    }

    @Test
    void deleteDeviceById() {
        doNothing().when(deviceRepository).deleteById(DeviceHelper.ID);
    }
}