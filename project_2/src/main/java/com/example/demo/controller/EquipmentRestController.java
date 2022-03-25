package com.example.demo.controller;

import com.example.demo.dto.EquipmentDTO;
import com.example.demo.dto.RequestMail;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.service.impl.EquipmentServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
     * @param id
     * @return ResponseEntity<>(equipment, HttpStatus.OK);
     */
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Equipment> findFloorsById(@PathVariable Integer id) {
        Equipment equipment = equipmentService.findById(id);
        if (equipment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }
    /**
     * Created: DuyNP
     * Method: send-email
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
     * @param requestMail
     */
    private void sendMail (RequestMail requestMail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(requestMail.getEmail());
        message.setSubject("[C0821G1] KÍNH CHÀO QUÝ KHÁCH");
        message.setText("Dear " +requestMail.getName() + ", \n \nCTY - TNHH C0821G1 CODEGYM Xin cảm ơn quý khách " +
                " đã gửi yêu cần hỗ trợ về công ty chúng tôi. \n" +
                " Xin quý khách vui lòng đợi, nhân viên của chúng tôi sẽ phản hồi lại email này theo thời gian sớm nhất.  \n" +
                " Xin cảm ơn quý khách đã quan tâm tới công ty chúng tôi! \n \n" +
                " Trân trong cảm ơn quý khách");
        this.emailSender.send(message);
    }

//    Đông
    @PostMapping("/add")
    public ResponseEntity<Object> addEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDTO, equipment);
        equipment.setDeleteFlag(false);
        equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(equipmentDTO,HttpStatus.CREATED);
    }

    @PatchMapping(value = "/edit")
    public ResponseEntity<Object> editEquipment(@RequestBody @Valid EquipmentDTO equipmentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDTO, equipment);
        equipmentService.editEquipment(equipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
