package com.juarcoding.pcmspringboot3.dto.report;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.juarcoding.pcmspringboot3.dto.rel.RelAksesDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class RepUserDTO {

    private Long id;

    private String username;

    private String email;

    private String noHp;

    private String namaLengkap;

    private String alamat;


    private String tanggalLahir;

    private String namaAkses;

    private Integer umur;

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Long getId() {
        return id;
    }

    public String getNamaAkses() {
        return namaAkses;
    }

    public void setNamaAkses(String namaAkses) {
        this.namaAkses = namaAkses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }


    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}