//package com.juarcoding.pcmspringboot3.controller;
//
//import com.juarcoding.pcmspringboot3.config.OtherConfig;
//import com.juarcoding.pcmspringboot3.config.SMTPConfig;
//import com.juarcoding.pcmspringboot3.dto.CustomerDTO;
//import com.juarcoding.pcmspringboot3.dto.DataDTO;
//import com.juarcoding.pcmspringboot3.service.CobaRestService;
//import com.juarcoding.pcmspringboot3.utils.FileUtility;
//import com.juarcoding.pcmspringboot3.utils.ForScheduler;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("hello")
//public class CobaRestController {
//
//    @Autowired
//    CobaRestService cobaRestService;
//
//    @Autowired
//    ForScheduler forScheduler;
//
////    public CobaRestService x (CobaRestService crs){
////        if(crs==null){
////            return new CobaRestService();
////        }
////        return crs;
////    }
//
//    private String cumicumi="OK";
//
//
//    @GetMapping("/gt")
//    public Object getData(){
//        Map<String,Object> map = new LinkedHashMap<>();
//        map.put("message","Login");
//        map.put("timestamp",new Date());
//        map.put("status",256);
//        map.put("path","hello/gt");
//        cobaRestService.save();
//        System.out.println("Nilai CumiCumi adalah "+cumicumi);
//        System.out.println("Isi Username SMTPConfig "+ SMTPConfig.getEmailUserName());
//        forScheduler.sampleAsync();
//        System.out.println("Gak Nunggu Fungsi !!");
////        DataDTO dto = new DataDTO();
////        dto.setMessage("login");
////        dto.setTimestamp(new Date());
////        dto.setStatus(256);
//        SMTPConfig.getEmailUserName();
//        OtherConfig.getEnableLogFile();
//        return map;
//    }
//
//    @PostMapping("/pst")
//    public String postData(){
//        return "Hello World Post!!";
//    }
//
//    @PutMapping("/pt")
//    public String putData(){
//        return "Hello World Put!!";
//    }
//
//    @GetMapping("/gt/{id}/{nama}")
//    public String inputData(
//                            @RequestParam String orang,
//                            @RequestParam String kunci,
//                            @RequestParam String nilai,
//                            @PathVariable String nama,
//                            @PathVariable int id
//                            ){
//        return id + nama + kunci + nilai + orang;
//    }
//
//    @PostMapping("/pt")
//    public String bodyData(
//            @Valid @RequestBody DataDTO dataDTO
//            ){
//        String strTimeStamp = dataDTO.getTimestamp().toString();
//        String strStatus = String.valueOf(dataDTO.getStatus());
//        String strMessage = dataDTO.getMessage();
//        String strNamaLengkap = dataDTO.getNamaLengkap();
//        String strSkrip = dataDTO.getSkrip();
//        System.out.println("Timestamp "+strTimeStamp);
//        System.out.println("Status "+strStatus);
//        System.out.println("Message "+strMessage);
//        System.out.println("Nama Lengkap "+strNamaLengkap);
//        System.out.println("Skrip "+strSkrip);
//        return strTimeStamp +"---"+ strStatus +"---"+ strMessage+"---"+ strNamaLengkap+"---"+ strSkrip;
//    }
//
//
//    @PostMapping("/postdata")
//    public String postData(@RequestBody CustomerDTO customerDTO){
//        String id=String.valueOf(customerDTO.getId());
//        String nama=customerDTO.getNama();
//        String jenisKelamin = customerDTO.getJenisKelamin();
//        String umur = String.valueOf(customerDTO.getUmur());
//        String jalan = customerDTO.getAlamat().getJalan();
//        String nomor = customerDTO.getAlamat().getNomor();
//        String kota = customerDTO.getAlamat().getKota();
//        String kodePos = customerDTO.getAlamat().getKodePos();
//        System.out.println("ID "+id);
//        System.out.println("Nama "+nama);
//        System.out.println("JK "+jenisKelamin);
//        System.out.println("Umur "+umur);
//        System.out.println("Jalan "+jalan);
//        System.out.println("Nomor "+nomor);
//        System.out.println("Kota "+kota);
//        System.out.println("KodePos "+kodePos);
//        return "OK";
//    }
//
//    @PostMapping("/kirim-file")
//    public String submitFile(@RequestParam MultipartFile kiriman,
//                             @RequestParam MultipartFile kiriman2,
//                             @RequestParam MultipartFile[] kirimanArr) throws IOException {
//
//        String fileName = StringUtils.cleanPath(kiriman.getOriginalFilename());
//        String strKiriman2 = StringUtils.cleanPath(kiriman2.getOriginalFilename());
//        System.out.println("Kiriman 2 File "+strKiriman2);
//        for (int i = 0; i < kirimanArr.length; i++) {
//            System.out.println("Kiriman Arr "+i+" File "+kirimanArr[i].getOriginalFilename());
//        }
//        String uploadDir = "user-files/";
//        FileUtility.saveFile(uploadDir, fileName, kiriman);
//        return "Berhasil mengunggah file " + fileName;
//    }
//
//    @GetMapping("/encr")
//    public String cobaEncrypt(){
//        return SMTPConfig.getEmailUserName()+" -- "+SMTPConfig.getEmailPassword();
//    }
//}