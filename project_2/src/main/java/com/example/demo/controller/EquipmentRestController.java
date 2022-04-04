package com.example.demo.controller;

import com.example.demo.dto.EquipmentDTO;
import com.example.demo.dto.RequestMail;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.service.impl.EquipmentServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.print.DocFlavor;
import javax.validation.Valid;

import java.util.List;
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
        Equipment equipment = equipmentService.findById(id);
        if (equipment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipment, HttpStatus.OK);
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
        message.setSubject("[C0821G1] KÍNH CHÀO QUÝ KHÁCH");
        message.setText("Dear " + requestMail.getName() + ", \n \nCTY - TNHH C0821G1 CODEGYM Xin cảm ơn quý khách " +
                " đã gửi yêu cần hỗ trợ về công ty chúng tôi. \n" +
                " Xin quý khách vui lòng đợi, nhân viên của chúng tôi sẽ phản hồi lại email này theo thời gian sớm nhất.  \n" +
                " Xin cảm ơn quý khách đã quan tâm tới công ty chúng tôi! \n \n" +
                " Trân trong cảm ơn quý khách");
        this.emailSender.send(message);
    }

//Đông
    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        List<Equipment> equipmentList = equipmentService.findList();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

//    Đông
    @PostMapping("/add")
    public ResponseEntity<Object> addEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO, BindingResult bindingResult) {

        if (equipmentService.checkCode(equipmentDTO.getCode())){
            System.out.println("lỗi");
            bindingResult.rejectValue("code","Mã vật tư đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            System.out.println("Loi Dong");
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
        }
        Equipment equipment = new Equipment();
        System.out.println(equipmentDTO.toString());
        BeanUtils.copyProperties(equipmentDTO, equipment);
        equipment.setDeleteFlag(false);
        equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(equipmentDTO,HttpStatus.CREATED);
    }

//    Đông
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> editEquipment(@RequestBody @Valid EquipmentDTO equipmentDTO, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDTO, equipment);
        equipmentService.editEquipment(equipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Tây chức năng tìm equipment theo id
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findEquipmentById(@PathVariable Integer id) {
        Optional<Equipment> equipmentOptional = this.equipmentService.findEquipmentById(id);
        if (!equipmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipmentOptional, HttpStatus.OK);
    }

    //Tây chức năng hiển thị thông tin vật tư
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

    //Tây chức năng xóa vật tư
    @DeleteMapping("delete-equipment/{id}")
    public ResponseEntity<Equipment> deleteCustomer(@PathVariable Integer id) {
        Optional<Equipment> equipmentOptional = equipmentService.findEquipmentById(id);
        if (!equipmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(equipmentOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkDay(@RequestParam("param1") String expired){
        boolean check = this.equipmentService.checkDate(expired);
        return new ResponseEntity<>(check, HttpStatus.OK);
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
//        message.setSubject("[C0821G1] KÍNH CHÀO QUÝ KHÁCH");
//        message.setText("Dear " +requestMail.getName() + ", \n \nCTY - TNHH C0821G1 CODEGYM Xin cảm ơn quý khách " +
//                " đã gửi yêu cần hỗ trợ về công ty chúng tôi. \n" +
//                " Xin quý khách vui lòng đợi, nhân viên của chúng tôi sẽ phản hồi lại email này theo thời gian sớm nhất.  \n" +
//                " Xin cảm ơn quý khách đã quan tâm tới công ty chúng tôi! \n \n" +
//                " Trân trong cảm ơn quý khách");
//        this.emailSender.send(message);
//    }

}
