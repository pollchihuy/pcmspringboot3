package com.juarcoding.pcmspringboot3.dto.validation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.juarcoding.pcmspringboot3.dto.rel.RelGroupMenuDTO;
import com.juarcoding.pcmspringboot3.model.GroupMenu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValMenuDTO {

    @NotNull(message = "Deskripsi Tidak Boleh Null")
    @Pattern(regexp = "^[\\w\\s]{5,50}$",message = "Nama Tidak Valid hanya Alfabet dan spasi Min 5 Max 50 , ex : User Management")
    private String nama;

    @NotNull(message = "Path Tidak Boleh Null")
    @Pattern(regexp = "^[a-z0-9\\/\\-]{5,50}$",message = "Path Tidak Valid huruf kecil , hyphen dan slash Min 5 Max 50 , ex : /group-menu")
    private String path;

    @NotNull(message = "Deskripsi Tidak Boleh Null")
    @Pattern(regexp = "^[a-zA-Z\\s]{15,255}$",message = "hanya Alfabet dan spasi Min 15 Max 255")
    private String deskripsi;

    @NotNull(message = "Relasi Tidak Boleh Kosong")
    @JsonProperty("group-menu")
    private RelGroupMenuDTO groupMenu;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public RelGroupMenuDTO getGroupMenu() {
        return groupMenu;
    }

    public void setGroupMenu(RelGroupMenuDTO groupMenu) {
        this.groupMenu = groupMenu;
    }
}