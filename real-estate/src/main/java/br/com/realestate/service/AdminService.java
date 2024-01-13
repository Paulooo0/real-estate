package br.com.realestate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.realestate.errors.EmailNotFoundException;
import br.com.realestate.errors.PhoneNotFoundException;
import br.com.realestate.model.Admin;
import br.com.realestate.repository.AdminRepository;

@Service
public class AdminService {
    
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void saveAdmin(Admin admin) {
        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new RuntimeException(admin.getFirstName() + " " + admin.getLastName() + " with email " + admin.getEmail() + " already exists");
        }
        adminRepository.save(admin);
    }

    public Admin findByPhone(String phone) throws PhoneNotFoundException {
        return adminRepository.findByPhone(phone).orElseThrow(() -> new PhoneNotFoundException(phone));
    }

    public Admin findByEmail(String email) throws EmailNotFoundException {
        return adminRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException(email));
    }

    public Boolean existsByEmail(String email) {
        return adminRepository.findByEmail(email).isPresent();
    }

    public void updateAdmin(String email, Admin admin) throws EmailNotFoundException {
        Admin existentAdmin = findByEmail(email);
        existentAdmin.setFirstName(admin.getFirstName());
        existentAdmin.setLastName(admin.getLastName());
        existentAdmin.setPhone(admin.getPhone());
        adminRepository.save(existentAdmin);
    }

    public void deleteAdmin(String email) throws EmailNotFoundException {
        Admin existentAdmin = findByEmail(email);
        adminRepository.delete(existentAdmin);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
