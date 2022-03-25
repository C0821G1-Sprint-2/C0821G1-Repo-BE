package com.example.demo.controller;
import com.example.demo.entity.cart.Cart;
import com.example.demo.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/cart")
public class CartRestController {

    @Autowired
    CartServiceImpl cartService;

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
}
