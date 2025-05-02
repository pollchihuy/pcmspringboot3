package com.juarcoding.pcmspringboot3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class DataDTO {

    @Pattern(regexp = "^[a-zA-Z0-9]{6,10}$")
    private String message;
    //negrikutercinta123
    //min 1 huruf kecil
    //min 1 huruf besar
    //min 1 angka
    //min 1 sp karakter @_-$#
    //min 8 maks 16
    private Date timestamp;
    private Integer status;
    @JsonProperty("nama-lengkap")
    private String namaLengkap;
    private String skrip;

    public String getSkrip() {
        return skrip;
    }

    public void setSkrip(String skrip) {
        this.skrip = skrip;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
