package com.webee.challenge.controller;

import com.webee.challenge.model.DeviceHelper;
import com.webee.challenge.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.containsString;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeviceController.class)
class DeviceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DeviceService deviceService;

    @Test
    void insertDeviceOk() throws Exception {
        given(deviceService.addDevice(Mockito.any())).willReturn(DeviceHelper.getDeviceOk());
        mvc.perform(post("/device")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DeviceHelper.JSON_BODY))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(DeviceHelper.JSON_RESPONSE)));
    }

    @Test
    void insertDeviceBadMac() throws Exception {
        given(deviceService.addDevice(Mockito.any())).willReturn(DeviceHelper.getDeviceMacAddressNoOk());
        mvc.perform(post("/device")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DeviceHelper.JSON_BODY_BAD_MAC))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Bad Request")));
    }

    @Test
    void insertDeviceBadDate() throws Exception {
        given(deviceService.addDevice(Mockito.any())).willReturn(DeviceHelper.getDeviceMacAddressNoOk());
        mvc.perform(post("/device")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DeviceHelper.JSON_BODY_BAD_DATE))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Bad Request")));
    }

    @Test
    void getByMAC() throws Exception {
        given(deviceService.findDeviceByMAC(DeviceHelper.MAC_ADDRESS_OK)).willReturn(DeviceHelper.getDeviceOk());
        mvc.perform(get("/device/mac/01:01:01:01:01:01")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(DeviceHelper.JSON_RESPONSE)));
    }

    @Test
    void getByMACNoOk() throws Exception {
        mvc.perform(get("/device/mac/01:01:01:01:0101")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No se ha encontrado el dispositivo")));
    }

    @Test
    void getById() throws Exception {
        given(deviceService.findDeviceById(DeviceHelper.ID)).willReturn(Optional.of(DeviceHelper.getDeviceOk()));
        mvc.perform(get("/device/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(DeviceHelper.JSON_RESPONSE)));
    }
}