//package com.juarcoding;
//
//import com.juarcoding.pcmspringboot3.utils.XMLFileConfig;
//import org.testng.TestNG;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainTestNG {
//
//
//    public static void main(String[] args) throws IOException {
//        String rootProject = System.getProperty("user.dir");
//        TestNG runner = new TestNG();
////        runner.setOutputDirectory(rootProject+"\\output-testng\\rest-assured\\"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss")));
//        List<String> suitefiles = new ArrayList<String>();
//        Class clazz = MainTestNG.class;
//        /**
//         * Masukkan seluruh file XML ke dalam folder resources
//         * parameter dari function copyResource harus menggunakan awalan "/" untuk path nya
//         */
//        String file = XMLFileConfig.copyResource("/run-suite-batch.xml",clazz);
//        /** file testng.xml itu sama dengan loadrunner.xml isi nya , hanya untuk test aja saya rename filenya */
//        for (int i = 0; i < 5000 ; i++) {
//            suitefiles.add("/run-suite-batch.xml");
//            runner.setTestSuites(suitefiles);
//        }
//        runner.run();
//    }
//}
