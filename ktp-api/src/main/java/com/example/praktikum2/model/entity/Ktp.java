package com.example.praktikum2.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "ktp") // Gunakan huruf kecil agar aman di MySQL
@Data
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomor_ktp", unique = true, nullable = false)
    private String nomorKtp;

    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
}