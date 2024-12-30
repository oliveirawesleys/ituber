package com.seguradora.acme.acme.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cotacaoseguro")
public class CotacaoSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCotacao;

    @JsonProperty("product_id")
    private UUID productId;

    @JsonProperty("offer_id")
    private UUID offerId;
    private String category;

    @JsonProperty("total_monthly_premium_amount")
    private Double totalMonthlyPremiumAmount;

    @JsonProperty("total_coverage_amount")
    private Double totalCoverageAmount;

    private String coveragesJson;

    @ElementCollection
    @CollectionTable(
            name = "policy_assistances",
            joinColumns = @JoinColumn(name = "insurance_policy_id")
    )
    @Column(name = "assistance_name")
    private List<String> assistances;

    @Embedded
    private Customer customer;

    private boolean isActive;

    public Map<String, Double> getCoverages() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(coveragesJson, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setCoverages(Map<String, Double> coverages) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.coveragesJson = objectMapper.writeValueAsString(coverages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
