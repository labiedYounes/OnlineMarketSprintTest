package com.example.controllers;

import com.example.models.Bill;
import com.example.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bills")
public class BillController {
   @Autowired
   private BillService billService;

   @GetMapping(value = "/")
   public ArrayList<Bill> bills() {
      return billService.findAll();
   }

   @GetMapping(value = "/{id}")
   public Bill find(@PathVariable Long id) {
      return billService.get(id);
   }

   @PostMapping(value="/")
   public Bill create(@RequestBody Bill bill){
	   return billService.create(bill);
   }

   @PutMapping(value="/{id}")
   public Bill update(@PathVariable Long id, @RequestBody Bill bill){
       bill.setId(id);
	   return billService.update(bill);
   }

   @DeleteMapping(value="/{id}")
   public ResponseEntity<?> delete(@PathVariable Long id){
	   billService.delete(id);
	   return new ResponseEntity<Bill>(HttpStatus.NO_CONTENT);
   }
}
