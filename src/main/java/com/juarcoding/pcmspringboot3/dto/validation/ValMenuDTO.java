package com.juarcoding.pcmspringboot3.dto.validation;


import com.juarcoding.pcmspringboot3.dto.response.ResGroupMenuDTO;
import jakarta.validation.constraints.Pattern;

public class ValMenuDTO {

    @Pattern(regexp = "^$")
    private String nama;

    private String path;

    private String deskripsi;

    private ResGroupMenuDTO groupMenu;

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

    public ResGroupMenuDTO getGroupMenu() {
        return groupMenu;
    }

    public void setGroupMenu(ResGroupMenuDTO groupMenu) {
        this.groupMenu = groupMenu;
    }
}