package com.example.demo.controller;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.RequestMail;
import com.example.demo.entity.cart.Address;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.customer.CustomerTransfer;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.impl.AddressService;
import com.example.demo.service.impl.CartServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/cart")
public class CartRestController {

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    AddressService addressService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    public JavaMailSender emailSender;

    /**
     * Created: DuyNP
     * Method: create cart
     * @param cart
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created: DuyNP
     * Method: get cart by id
      * @param id
     * @return
     */
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Cart> findFloorsById(@PathVariable Integer id) {
        Cart cart = cartService.findById(id);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddressList(){
        List<Address> addressList = addressService.getAll();
        if(!addressList.isEmpty()){
            return new ResponseEntity<>(addressList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value="home/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createCart( @RequestBody PaymentDTO paymentDTO) {
        CustomerTransfer customerTransfer = paymentDTO.getCustomerTransfer();
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties( customerTransfer,customerDTO);
        List<Cart> cartList = paymentDTO.getCartList();
        Iterable<Customer> customerList = iCustomerService.findAll();
        customerDTO.setCustomers(customerList);
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setAddress(new Address(customerTransfer.getAddress().getId(),customerTransfer.getAddress().getName()));
        iCustomerService.save(customer);
        sendEmail(customer,cartList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private void sendEmail (Customer customer,List<Cart> cartList){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(customer.getEmail());
        message.setSubject("[Thông báo] Xác nhận thanh toán thành công");
        String textMessage = "Kính gửi: Quý khách " +customer.getName()+ ".\n" +
                "Vật tư y tế CodeGym xin trân trọng gửi đến quý khách : \n" +
                "THÔNG BÁO XÁC NHẬN ĐẶT HÀNG THÀNH CÔNG ! \n"
                + "Đơn hàng của quý khách bao gồm: \n" ;
        int totalMoney = 0;
        for (Cart cart : cartList) {
            totalMoney += (cart.getTotalMoney() * cart.getQuantity());
            textMessage += cart.getCode() + " với số lượng: " + cart.getQuantity() + " \n";
        }
        textMessage += "Tổng giá tiền đơn hàng của quý khách là: "+ totalMoney + " !";
        message.setText(textMessage);
        // Send Message!
        this.emailSender.send(message);
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
}
