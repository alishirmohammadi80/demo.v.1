package com.example.demo.kala;

import java.util.List;

public interface KalaService {
    List<Kala> getAllKala();
    Kala saveKala(Kala kala);
    Kala getKalaById(Long id);
    Kala updateKala(Kala kala);
    void deleteKalaById(Long id);
}
