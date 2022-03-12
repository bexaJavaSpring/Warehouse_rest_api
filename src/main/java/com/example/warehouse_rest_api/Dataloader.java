//package com.example.warehouse_rest_api;
//
//import com.example.warehouse_rest_api.entity.*;
//import com.example.warehouse_rest_api.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Dataloader implements CommandLineRunner {
//@Value("${spring.sql.init.mode}")
//private String mode;
//@Value("${spring.jpa.hibernate.ddl-auto}")
//private String ddl;
//
//@Autowired
//    MeasurementRepository measurementRepository;
//@Autowired
//AttachmentRepository attachmentRepository;
//@Autowired
//WarehouseRepository warehouseRepository;
//@Autowired
//CategoryRepository categoryRepository;
//@Autowired
//    ProductRepository productRepository;
//@Autowired
//CurrencyRepository currencyRepository;
//@Autowired
//OutputRepository outputRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        if(ddl.equals("create") && mode.equals("always")){
//            Measurement measurement=new Measurement("ta",true);
//            Measurement measurement1=new Measurement("dona",true);
//            Measurement measurement2=new Measurement("kg",true);
//            Measurement measurement3=new Measurement("litr",true);
//            measurementRepository.save(measurement);
//            measurementRepository.save(measurement1);
//            measurementRepository.save(measurement2);
//            measurementRepository.save(measurement3);
//            Attachment attachment=new Attachment("rasm.jpeg",12,"jpeg");
//            Attachment attachment1=new Attachment("mp3.ru",1200,"ru");
//            attachmentRepository.save(attachment);
//            attachmentRepository.save(attachment1);
//            Warehouse warehouse=new Warehouse("Bekhruz",true);
//            Warehouse warehouse1=new Warehouse("Akramxon",true);
//            Warehouse warehouse2=new Warehouse("Mamanjon",true);
//            warehouseRepository.save(warehouse);
//            warehouseRepository.save(warehouse1);
//            warehouseRepository.save(warehouse2);
//            Category category=new Category("Kompyuterlar",true);
//            Category category1=new Category("Smartfonlar",true);
//            Category category2=new Category("Televizorlar",true);
//            Category category3=new Category("Ichimliklar",true);
//            Category category4=new Category("Oziq-ovqatlar",true);
//            Category category5=new Category("Mebellar",true);
//            Category category6=new Category("Others",true);
//            categoryRepository.save(category);
//            categoryRepository.save(category1);
//            categoryRepository.save(category2);
//            categoryRepository.save(category3);
//            categoryRepository.save(category4);
//            categoryRepository.save(category5);
//            categoryRepository.save(category6);
//        }
//    }
//}
