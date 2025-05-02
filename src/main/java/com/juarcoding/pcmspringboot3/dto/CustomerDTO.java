package com.juarcoding.pcmspringboot3.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {
    private Long id;
    private String nama;
    @JsonProperty("jenis_kelamin")
    private String jenisKelamin;
    private Integer umur;
    private AlamatDTO alamat;

    public AlamatDTO getAlamat() {
        return alamat;
    }

    public void setAlamat(AlamatDTO alamat) {
        this.alamat = alamat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }
}
