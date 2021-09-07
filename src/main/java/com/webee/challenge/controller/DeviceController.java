package com.webee.challenge.controller;

import com.webee.challenge.device.exception.DeviceBadRequestException;
import com.webee.challenge.model.Device;
import com.webee.challenge.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("device")
public class DeviceController {

    private final DeviceService deviceService;

    /**
     * Instantiates a new Device controller.
     *
     * @param deviceService the device service
     */
    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Device> insetUser(@RequestBody Device device) {
        if(device.getMac() == null){
            throw new DeviceBadRequestException("El dispositivo no es correcto");
        }
        deviceService.addDevice(device);
        return new ResponseEntity<Device>
                (deviceService.findDeviceByMAC(device.getMac()), HttpStatus.OK);
    }
}
