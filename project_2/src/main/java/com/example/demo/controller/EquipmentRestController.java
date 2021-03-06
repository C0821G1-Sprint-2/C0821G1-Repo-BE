package com.example.demo.controller;

import com.example.demo.dto.RequestMail;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.service.impl.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/equipment")
public class EquipmentRestController {
    @Autowired
    EquipmentServiceImpl equipmentService;

    @Autowired
    public JavaMailSender emailSender;

    /**
     * Created: DuyNP
     * Method: return equipment by id
     *
     * @param id
     * @return ResponseEntity<>(equipment, HttpStatus.OK);
     */
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Equipment> findFloorsById(@PathVariable Integer id) {
//        Equipment equipment = equipmentService.findById(id);
//        if (equipment == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(equipment, HttpStatus.OK);
        return null;
    }

    /**
     * Created: DuyNP
     * Method: send-email
     *
     * @param requestMail
     * @return ResponseEntity<>(HttpStatus.OK);
     */
    @PostMapping("send-email")
    public ResponseEntity<?> sendEmailTo(@RequestBody RequestMail requestMail) {
        sendMail(requestMail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created: DuyNP
     *
     * @param requestMail
     */
    private void sendMail(RequestMail requestMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(requestMail.getEmail());
        message.setSubject("[C0821G1] K??NH CH??O QU?? KH??CH");
        message.setText("Dear " + requestMail.getName() + ", \n \nCTY - TNHH C0821G1 CODEGYM Xin ca??m ??n quy?? kha??ch " +
                " ??a?? g????i y??u c????n h???? tr???? v???? c??ng ty chu??ng t??i. \n" +
                " Xin quy?? kha??ch vui lo??ng ??????i, nh??n vi??n cu??a chu??ng t??i se?? pha??n h????i la??i email na??y theo th????i gian s????m nh????t.  \n" +
                " Xin ca??m ??n quy?? kha??ch ??a?? quan t??m t????i c??ng ty chu??ng t??i! \n \n" +
                " Tr??n trong ca??m ??n quy?? kha??ch");
        this.emailSender.send(message);
    }


    // NghiaDM danh sach vat tu
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Equipment>> equipmentList (@PageableDefault(value = 3) Pageable pageable){
        Page<Equipment> equipments = this.equipmentService.getAll(pageable);
        if (equipments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }

    //T??y ch???c n??ng t??m equipment theo id
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findEquipmentById(@PathVariable Integer id) {
        Optional<Equipment> equipmentOptional = this.equipmentService.findEquipmentById(id);
        if (!equipmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipmentOptional, HttpStatus.OK);
    }

    //T??y ch???c n??ng hi???n th??? th??ng tin v???t t??
    @GetMapping("/equipment-list")
    public ResponseEntity<Page<Equipment>> findContractByNameAndCodeAndDate(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page
    ) {

        Pageable pageable = PageRequest.of(page, 2);
        Page<Equipment> equipmentNewPage = equipmentService.findAllEquipmentByKeyword(keyword, pageable);
        System.out.println(equipmentNewPage);
        if (equipmentNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(equipmentNewPage, HttpStatus.OK);

    }

    //T??y ch???c n??ng x??a v???t t??
    @DeleteMapping("delete-equipment/{id}")
    public ResponseEntity<Equipment> deleteCustomer(@PathVariable Integer id) {
        Optional<Equipment> equipmentOptional = equipmentService.findEquipmentById(id);
        if (!equipmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(equipmentOptional.get(), HttpStatus.OK);
    }
//    @GetMapping("/find-by-id/{id}")
//    public ResponseEntity<Equipment> findFloorsById(@PathVariable Integer id) {
//        Equipment equipment = equipmentService.findById(id);
//        if (equipment == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(equipment, HttpStatus.OK);
//    }
//    /**
//     * Created: DuyNP
//     * Method: send-email
//     * @param requestMail
//     * @return ResponseEntity<>(HttpStatus.OK);
//     */
//    @PostMapping("send-email")
//    public ResponseEntity<?> sendEmailTo(@RequestBody RequestMail requestMail) {
//        sendMail(requestMail);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    /**
//     * Created: DuyNP
//     * @param requestMail
//     */
//    private void sendMail (RequestMail requestMail){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(requestMail.getEmail());
//        message.setSubject("[C0821G1] K??NH CH??O QU?? KH??CH");
//        message.setText("Dear " +requestMail.getName() + ", \n \nCTY - TNHH C0821G1 CODEGYM Xin ca??m ??n quy?? kha??ch " +
//                " ??a?? g????i y??u c????n h???? tr???? v???? c??ng ty chu??ng t??i. \n" +
//                " Xin quy?? kha??ch vui lo??ng ??????i, nh??n vi??n cu??a chu??ng t??i se?? pha??n h????i la??i email na??y theo th????i gian s????m nh????t.  \n" +
//                " Xin ca??m ??n quy?? kha??ch ??a?? quan t??m t????i c??ng ty chu??ng t??i! \n \n" +
//                " Tr??n trong ca??m ??n quy?? kha??ch");
//        this.emailSender.send(message);
//    }
}
