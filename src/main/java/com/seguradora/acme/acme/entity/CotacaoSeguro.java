package com.seguradora.acme.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CotacaoSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCotacao;

    private Long product_id;
    private Long offer_id;
    private String category;
    private String total_monthly_premium_amount;
    private String total_coverage_amount;
}
