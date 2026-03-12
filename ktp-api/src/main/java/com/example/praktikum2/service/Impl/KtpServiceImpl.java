package com.example.praktikum2.service.Impl;

import com.example.praktikum2.mapper.KtpMapper;
import com.example.praktikum2.model.dto.KtpAddRequest;
import com.example.praktikum2.model.dto.KtpDto;
import com.example.praktikum2.model.entity.Ktp;
import com.example.praktikum2.repository.KtpRepository;
import com.example.praktikum2.service.KtpService;
import com.example.praktikum2.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Override
    public KtpDto createKtp(KtpAddRequest request) {
        // Panggil ValidationUtil
        ValidationUtil.validateNomorKtpExists(ktpRepository.existsByNomorKtp(request.getNomorKtp()));

        Ktp ktp = KtpMapper.mapToEntity(request);
        Ktp savedKtp = ktpRepository.save(ktp);
        return KtpMapper.mapToDto(savedKtp);
    }

    @Override
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(KtpMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        return KtpMapper.mapToDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpAddRequest request) {
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));

        existingKtp.setNomorKtp(request.getNomorKtp());
        existingKtp.setNamaLengkap(request.getNamaLengkap());
        existingKtp.setAlamat(request.getAlamat());
        existingKtp.setTanggalLahir(request.getTanggalLahir());
        existingKtp.setJenisKelamin(request.getJenisKelamin());

        Ktp updatedKtp = ktpRepository.save(existingKtp);
        return KtpMapper.mapToDto(updatedKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        ktpRepository.delete(existingKtp);
    }
}
