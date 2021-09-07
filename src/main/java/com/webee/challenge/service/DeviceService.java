package com.webee.challenge.service;

import com.webee.challenge.model.Device;
import com.webee.challenge.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    /**
     * Instantiates a new Device service.
     *
     * @param deviceRepository the device repository
     */
    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    /**
     * Add device.
     *
     * @param device the device
     */
    public Device addDevice(Device device){
        return deviceRepository.save(device);
    }

    /**
     * Find device by mac device.
     * The method recieve the mac of the device
     * @param mac of the device
     * @return the device
     */
    public Device findDeviceByMAC(String mac){
        Device device = deviceRepository.findBymac(mac);
        return device;
    }
}
