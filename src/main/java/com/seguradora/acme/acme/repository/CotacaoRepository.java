package com.seguradora.acme.acme.repository;


import com.seguradora.acme.acme.entity.CotacaoSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CotacaoRepository extends JpaRepository<CotacaoSeguro, Long> {

    Optional<CotacaoSeguro> findById(UUID productId);
}
