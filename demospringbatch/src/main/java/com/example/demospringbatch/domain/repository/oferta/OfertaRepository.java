package com.example.demospringbatch.domain.repository.oferta;

import com.example.demospringbatch.domain.oferta.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfertaRepository extends JpaRepository<OfertaEntity, UUID> {
}
