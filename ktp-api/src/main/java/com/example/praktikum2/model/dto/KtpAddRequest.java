package com.example.praktikum2.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data // Ini sudah cukup untuk generate Getter/Setter otomatis
public class KtpAddRequest {
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
}