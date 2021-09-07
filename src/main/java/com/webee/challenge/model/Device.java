package com.webee.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webee.challenge.valitors.MacAddressContraint;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @SequenceGenerator(
            name = "device_sequence",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_sequence"
    )
    @Column(unique = true, nullable = false)
    private Integer id;

    @MacAddressContraint
    private String mac;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date timestamp = new Date();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}