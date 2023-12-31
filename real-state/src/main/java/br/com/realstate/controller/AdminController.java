package br.com.realstate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.realstate.errors.EmailNotFoundException;
import br.com.realstate.errors.PhoneNotFoundException;
import br.com.realstate.model.Admin;
import br.com.realstate.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) throws EmailNotFoundException {
        Admin admin = adminService.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(admin);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Admin> getAdminByPhone(@PathVariable String phone) throws PhoneNotFoundException {
        Admin admin = adminService.findByPhone(phone);
        return ResponseEntity.status(HttpStatus.OK).body(admin);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAll());
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String email, @RequestBody Admin admin) throws EmailNotFoundException {
        adminService.updateAdmin(email, admin);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String email) throws EmailNotFoundException {
        String adminFirstName = adminService.findByEmail(email).getFirstName();
        String adminLastName = adminService.findByEmail(email).getLastName();

        adminService.deleteAdmin(email);
        return ResponseEntity.status(HttpStatus.OK).body("Admin " + adminFirstName + " " + adminLastName + " was deleted");
    }
}
