package com.juarcoding.pcmspringboot3.dto.validation;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ValGroupMenuDTO {


    @NotNull(message = "Nama Tidak Boleh Null")
    @Pattern(regexp = "^[a-zA-Z\\s]{5,50}$",message = "Nama Tidak Valid hanya Alfabet dan spasi Min 5 Max 50 , ex : User Management")
    private String nama;

    //<script>alert('hello!')</script>
    @NotNull(message = "Deskripsi Tidak Boleh Null")
    @Pattern(regexp = "^[a-zA-Z\\s]{15,255}$",message = "hanya Alfabet dan spasi Min 15 Max 255")
    private String deskripsi;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
