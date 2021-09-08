package com.webee.challenge.service;

import com.webee.challenge.model.Device;
import com.webee.challenge.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * Find all devices.
     *
     * @return the list
     */
    public List<Device> findAll(){
        List<Device> devices = deviceRepository.findAll();
        return devices;
    }

    /**
     * Find device by id optional.
     * The method recieve the id of the device
     * @param id of the device
     * @return the optional
     */
    public Optional<Device> findDeviceById(Integer id){
        return deviceRepository.findById(id);
    }

    /**
     * Delete device by id.
     * The method recieve the id of the device
     * @param id the id
     */
    public void deleteDeviceById(Integer id){
        deviceRepository.deleteById(id);
    }
}
