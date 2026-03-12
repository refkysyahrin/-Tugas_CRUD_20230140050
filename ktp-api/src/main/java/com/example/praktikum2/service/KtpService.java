package com.example.praktikum2.service;

import com.example.praktikum2.model.dto.KtpAddRequest;
import com.example.praktikum2.model.dto.KtpDto;

import java.util.List;

public interface KtpService {
    KtpDto createKtp(KtpAddRequest request);
    List<KtpDto> getAllKtp();
    KtpDto getKtpById(Integer id);
    KtpDto updateKtp(Integer id, KtpAddRequest request);
    void deleteKtp(Integer id);
}