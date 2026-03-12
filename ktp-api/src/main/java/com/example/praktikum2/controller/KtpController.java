package com.example.praktikum2.controller;

import com.example.praktikum2.model.dto.KtpAddRequest;
import com.example.praktikum2.model.dto.KtpDto;
import com.example.praktikum2.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public KtpDto addKtp(@RequestBody KtpAddRequest request) {
        return ktpService.createKtp(request);
    }

    @GetMapping
    public List<KtpDto> getAllKtp() {
        return ktpService.getAllKtp();
    }

    @GetMapping("/{id}")
    public KtpDto getKtpById(@PathVariable Integer id) {
        return ktpService.getKtpById(id);
    }

    @PutMapping("/{id}")
    public KtpDto updateKtp(@PathVariable Integer id, @RequestBody KtpAddRequest request) {
        return ktpService.updateKtp(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return "Data KTP berhasil dihapus.";
    }
}
