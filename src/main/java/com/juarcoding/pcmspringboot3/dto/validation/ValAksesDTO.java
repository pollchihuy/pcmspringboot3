package com.juarcoding.pcmspringboot3.dto.validation;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.juarcoding.pcmspringboot3.dto.rel.RelMenuDTO;
import com.juarcoding.pcmspringboot3.model.Menu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

public class ValAksesDTO {

    @NotNull(message = "Nama Tidak Boleh Null")
    @Pattern(regexp = "^[a-zA-Z\\s]{5,50}$",message = "Nama Tidak Valid hanya Alfabet dan spasi Min 5 Max 50 , ex : User Management")
    private String nama;

    @NotNull(message = "Deskripsi Tidak Boleh Null")
    @Pattern(regexp = "^[a-zA-Z\\s]{15,255}$",message = "hanya Alfabet dan spasi Min 15 Max 255")
    private String deskripsi;


    @NotNull(message = "Relasi Tidak Boleh NULL")
    @JsonProperty("list-menu")
    private List<RelMenuDTO> listMenu;

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

    public List<RelMenuDTO> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<RelMenuDTO> listMenu) {
        this.listMenu = listMenu;
    }
}
