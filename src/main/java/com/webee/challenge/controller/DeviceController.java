package com.webee.challenge.controller;

import com.webee.challenge.device.exception.DeviceBadRequestException;
import com.webee.challenge.device.exception.DeviceNotFoundException;
import com.webee.challenge.model.Device;
import com.webee.challenge.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Insert the new device.
     *
     * @param device that contains an id, a mac and timestamp
     * @return the device
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Device> insertDevice(@RequestBody Device device) {
        if(device.getMac() == null){
            throw new DeviceBadRequestException("El dispositivo no es correcto");
        }
        deviceService.addDevice(device);
        return new ResponseEntity<Device>
                (deviceService.findDeviceByMAC(device.getMac()), HttpStatus.OK);
    }

    /**
     * Get all devices list.
     *
     * @return the list
     */
    @GetMapping("/all")
    public List<Device> getAllDevices(){
        return deviceService.findAll();
    }

    /**
     * Get by mac response entity.
     *
     * @param mac of the device
     * @return the response entity
     */
    @GetMapping("/mac/{mac}")
    public ResponseEntity<Device> getByMAC(@PathVariable String mac){
        Device macDevice = deviceService.findDeviceByMAC(mac);
        System.out.println(mac);
        if(macDevice == null){
            throw new DeviceNotFoundException("No se ha encontrado el dispositivo");
        }
        return new ResponseEntity<Device>(macDevice, HttpStatus.OK);
    }
}
