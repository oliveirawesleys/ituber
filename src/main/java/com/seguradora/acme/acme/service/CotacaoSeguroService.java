package com.seguradora.acme.acme.service;

import com.seguradora.acme.acme.entity.CotacaoSeguro;
import com.seguradora.acme.acme.repository.CotacaoRepository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class CotacaoSeguroService {

    private CotacaoRepository cotacaoRepository;


    public boolean estaAtivo(UUID productId, UUID offerId) {

        Optional<CotacaoSeguro> productOptional = cotacaoRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new IllegalArgumentException("Produto está inativo.");
        }

        return true;
    }

    public double calculaTotalCoberturas(Map<String, Double> coverages, double totalCoverageAmount) {
        double calculaTotal = coverages.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        if (calculaTotal != totalCoverageAmount) {
            throw new IllegalArgumentException("Valor total das coberturas esta diferente do informado.");
        }

        return calculaTotal;
    }

    public boolean premioEstaEntreMaxEMin(double totalMonthlyPremiumAmount, double minPremium, double maxPremium) {
        return totalMonthlyPremiumAmount >= minPremium && totalMonthlyPremiumAmount <= maxPremium;
    }
}
