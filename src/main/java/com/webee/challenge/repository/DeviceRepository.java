package com.webee.challenge.repository;

import com.webee.challenge.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    Device findBymac(String mac);
}