package com.juarcoding.pcmspringboot3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate tanggalLahir;

    @Pattern(regexp = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")
    private String ipAddressV4;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[\\w@$!%*?&]{8,16}$")
    private String password;

    @Pattern(regexp = "^(https?:\\/\\/)?(www\\.)?([a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+)(\\/[^\\s]*)?$",message = "Format Tidak Valid ex : https://www.example.com")
    private String url;

    @Pattern(regexp = "^[\\w._-]{3,16}$")
    private String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(@Pattern(regexp = "^(https?:\\/\\/)?(www\\.)?([a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+)(\\/[^\\s]*)?$", message = "Format Tidak Valid ex : https://www.example.com") String url) {
        this.url = url;
    }

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
