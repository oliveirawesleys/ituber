package com.seguradora.acme.acme.repository;


import com.seguradora.acme.acme.entity.CotacaoSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<CotacaoSeguro, Long> {
}
