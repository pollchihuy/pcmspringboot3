package com.juarcoding.pcmspringboot3.service;


import com.juarcoding.pcmspringboot3.core.IReport;
import com.juarcoding.pcmspringboot3.core.IService;
import com.juarcoding.pcmspringboot3.dto.report.RepGroupMenuDTO;
import com.juarcoding.pcmspringboot3.dto.response.ResGroupMenuDTO;
import com.juarcoding.pcmspringboot3.dto.validation.ValGroupMenuDTO;
import com.juarcoding.pcmspringboot3.handler.ResponseHandler;
import com.juarcoding.pcmspringboot3.model.GroupMenu;
import com.juarcoding.pcmspringboot3.repo.GroupMenuRepo;
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
 * Kode Modul : 01
 * Kode Validation / Error  : FV - FE
 */
@Service
@Transactional
public class GroupMenuService implements IService<GroupMenu>, IReport<GroupMenu> {

    @Autowired
    private GroupMenuRepo groupMenuRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransformPagination tp;

    @Override
    public ResponseEntity<Object> save(GroupMenu groupMenu, HttpServletRequest request) {//001-010
        try{
            if(groupMenu == null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT01FV001",request);
            }
            groupMenu.setCreatedBy(1L);
            groupMenuRepo.save(groupMenu);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("DATA GAGAL DISIMPAN ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT01FE001",request);
        }
        return new ResponseHandler().handleResponse("DATA BERHASIL DISIMPAN !!",HttpStatus.CREATED,null,null,request);
    }

    @Override
    public ResponseEntity<Object> update(Long id, GroupMenu groupMenu, HttpServletRequest request) {//011-020
        try{
            if(id == null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT01FV011",request);
            }
            if(groupMenu == null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT01FV012",request);
            }
            Optional<GroupMenu> opGroupMenu = groupMenuRepo.findById(id);
            if(!opGroupMenu.isPresent()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT01FV013",request);
            }
            GroupMenu groupMenuDB = opGroupMenu.get();
            groupMenuDB.setNama(groupMenu.getNama());
            groupMenuDB.setDeskripsi(groupMenu.getDeskripsi());
            groupMenuDB.setModifiedBy(1L);

        }catch (Exception e){
            return new ResponseHandler().handleResponse("DATA GAGAL DIUBAH ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT01FE011",request);
        }
        return new ResponseHandler().handleResponse("DATA BERHASIL DIUBAH !!",HttpStatus.OK,null,null,request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {//021-030
        try{
            if(id==null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT01FV021",request);
            }
            Optional<GroupMenu> opGroupMenu = groupMenuRepo.findById(id);
            if(!opGroupMenu.isPresent()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT01FV022",request);
            }
            groupMenuRepo.deleteById(id);

        }catch (Exception e){
            return new ResponseHandler().handleResponse("DATA GAGAL DIHAPUS ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT01FE021",request);
        }
        return new ResponseHandler().handleResponse("DATA BERHASIL DIHAPUS !!",HttpStatus.OK,null,null,request);
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {//031-040
        Page<GroupMenu> page = null;
        List<GroupMenu> list = null;
        List<RepGroupMenuDTO> listDTO = null;
        Map<String,Object> data = null;
        try {
            page = groupMenuRepo.findAll(pageable);
            if(page.isEmpty()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT01FV031",request);
            }
            listDTO = mapToDTO(page.getContent());
            data = tp.transformPagination(listDTO,page,"id","");
        }catch (Exception e){
            return new ResponseHandler().handleResponse("TERJADI KESALAHAN", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT01FE031",request);
        }
        return new ResponseHandler().handleResponse("DATA DITEMUKAN",HttpStatus.OK,
                data,null,request);
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {//041-050
        ResGroupMenuDTO resGroupMenuDTO = null;
        try{
            if(id==null){
                return new ResponseHandler().handleResponse("Object Null !!", HttpStatus.BAD_REQUEST,null,"AUT01FV041",request);
            }
            Optional<GroupMenu> opGroupMenu = groupMenuRepo.findById(id);
            if(!opGroupMenu.isPresent()){
                return new ResponseHandler().handleResponse("Data Tidak Ditemukan !!", HttpStatus.BAD_REQUEST,null,"AUT01FV042",request);
            }
            GroupMenu groupMenuDB = opGroupMenu.get();
            resGroupMenuDTO = mapToDTO(groupMenuDB);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("TERJADI KESALAHAN ", HttpStatus.INTERNAL_SERVER_ERROR,null,"AUT01FE041",request);
        }

        return new ResponseHandler().handleResponse("DATA DITEMUKAN !!",HttpStatus.OK,resGroupMenuDTO,null,request);
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
    public List<GroupMenu> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId) {
        return List.of();
    }

    @Override
    public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void generateToPDF(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    /** additional function */

    public GroupMenu mapToGroupMenu(ValGroupMenuDTO valGroupMenuDTO){
        return modelMapper.map(valGroupMenuDTO, GroupMenu.class);
    }

    public List<RepGroupMenuDTO> mapToDTO(List<GroupMenu> listGroupMenu){
        return modelMapper.map(listGroupMenu,new TypeToken<List<RepGroupMenuDTO>>(){}.getType());
    }

    public ResGroupMenuDTO mapToDTO(GroupMenu groupMenu){
        return modelMapper.map(groupMenu,ResGroupMenuDTO.class);
    }
}