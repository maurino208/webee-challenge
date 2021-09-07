package com.webee.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    private String mac;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date timestamp = new Date();


    public Integer getId() {
        return id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac.replaceAll("(..)(?!$)", "$1:");
    }

    public Date getTimestamp() {
        return timestamp;
    }
}