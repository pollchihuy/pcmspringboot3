package com.juarcoding.pcmspringboot3.service;


import com.juarcoding.pcmspringboot3.core.IReport;
import com.juarcoding.pcmspringboot3.core.IService;
import com.juarcoding.pcmspringboot3.dto.report.RepMenuDTO;
import com.juarcoding.pcmspringboot3.dto.response.ResMenuDTO;
import com.juarcoding.pcmspringboot3.dto.validation.ValMenuDTO;
import com.juarcoding.pcmspringboot3.handler.ResponseHandler;
import com.juarcoding.pcmspringboot3.model.Menu;
import com.juarcoding.pcmspringboot3.repo.MenuRepo;
import com.juarcoding.pcmspringboot3.utils.TransformPagination;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Kode Platform / Aplikasi : AUT
 * Kode Modul : 02
 * Kode Validation / Error  : FV - FE
 */
@Service
@Transactional
public class MenuService implements IService<Menu>, IReport<Menu> {

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransformPagination tp;

    @Override
    public ResponseEntity<Object> save(Menu menu, HttpServletRequest request) {//001-010
        try{
            if(menu == null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT02FV001",request);
            }
            menu.setCreatedBy(1L);
            menuRepo.save(menu);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("DATA GAGAL DISIMPAN ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT02FE001",request);
        }
        return new ResponseHandler().handleResponse("DATA BERHASIL DISIMPAN !!",HttpStatus.CREATED,null,null,request);
    }

    @Override
    public ResponseEntity<Object> update(Long id, Menu menu, HttpServletRequest request) {//011-020
        try{
            if(id == null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT02FV011",request);
            }
            if(menu == null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT02FV012",request);
            }
            Optional<Menu> opMenu = menuRepo.findById(id);
            if(!opMenu.isPresent()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT02FV013",request);
            }
            Menu menuDB = opMenu.get();
            menuDB.setNama(menu.getNama());
            menuDB.setDeskripsi(menu.getDeskripsi());
            menuDB.setModifiedBy(1L);

        }catch (Exception e){
            return new ResponseHandler().handleResponse("DATA GAGAL DIUBAH ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT02FE011",request);
        }
        return new ResponseHandler().handleResponse("DATA BERHASIL DIUBAH !!",HttpStatus.OK,null,null,request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {//021-030
        try{
            if(id==null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT02FV021",request);
            }
            Optional<Menu> opMenu = menuRepo.findById(id);
            if(!opMenu.isPresent()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT02FV022",request);
            }
            menuRepo.deleteById(id);

        }catch (Exception e){
            return new ResponseHandler().handleResponse("DATA GAGAL DIHAPUS ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT02FE021",request);
        }
        return new ResponseHandler().handleResponse("DATA BERHASIL DIHAPUS !!",HttpStatus.OK,null,null,request);
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {//031-040
        Page<Menu> page = null;
        List<Menu> list = null;
        List<RepMenuDTO> listDTO = null;
        Map<String,Object> data = null;
        try {
            page = menuRepo.findAll(pageable);
            if(page.isEmpty()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT02FV031",request);
            }
            listDTO = mapToDTO(page.getContent());
            data = tp.transformPagination(listDTO,page,"id","");
        }catch (Exception e){
            return new ResponseHandler().handleResponse("TERJADI KESALAHAN", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT02FE031",request);
        }
        return new ResponseHandler().handleResponse("DATA DITEMUKAN",HttpStatus.OK,
                data,null,request);
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {//041-050
        ResMenuDTO resMenuDTO = null;
        try{
            if(id==null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT02FV041",request);
            }
            Optional<Menu> opMenu = menuRepo.findById(id);
            if(!opMenu.isPresent()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT02FV042",request);
            }
            Menu menuDB = opMenu.get();
            resMenuDTO = mapToDTO(menuDB);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("TERJADI KESALAHAN ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT02FE041",request);
        }

        return new ResponseHandler().handleResponse("DATA DITEMUKAN !!",HttpStatus.OK,resMenuDTO,null,request);
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> uploadDataExcel(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }

    @Override
    public List<Menu> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId) {
        return List.of();
    }

    @Override
    public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void generateToPDF(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    /** additional function */

    public Menu mapToMenu(ValMenuDTO valMenuDTO){
        return modelMapper.map(valMenuDTO, Menu.class);
    }

    public List<RepMenuDTO> mapToDTO(List<Menu> listMenu){
        return modelMapper.map(listMenu,new TypeToken<List<RepMenuDTO>>(){}.getType());
    }

    public ResMenuDTO mapToDTO(Menu menu){
        return modelMapper.map(menu,ResMenuDTO.class);
    }
}