package com.example.demo.kala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KalaServiceImpl implements KalaService {
    @Autowired
    KalaRepository kalaRepository;

    @Override
    public List<Kala> getAllKala() {
        return kalaRepository.findAll();
    }

    @Override
    public Kala saveKala(Kala kala) {
        return kalaRepository.save(kala);
    }

    @Override
    public Kala getKalaById(Long id) {
        return kalaRepository.findById(id).get();
    }

    @Override
    public Kala updateKala(Kala kala) {
        return kalaRepository.save(kala);
    }

    @Override
    public void deleteKalaById(Long id) {
        kalaRepository.deleteById(id);
    }

}
