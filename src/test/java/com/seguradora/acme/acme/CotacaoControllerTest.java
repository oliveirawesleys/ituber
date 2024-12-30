package com.seguradora.acme.acme;

import com.seguradora.acme.acme.controller.CotacaoController;
import com.seguradora.acme.acme.entity.CotacaoSeguro;
import com.seguradora.acme.acme.repository.CotacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;


public class CotacaoControllerTest {

    @Mock
    private CotacaoRepository cotacaoRepository;

    @InjectMocks
    private CotacaoController cotacaoController;

    private UUID validProductId;
    private UUID validOfferId;
    private UUID invalidProductId;
    private UUID invalidOfferId;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        validProductId = UUID.fromString("1b2da7cc-b367-4196-8a78-9cfeec21f587");
        validOfferId = UUID.fromString("adc56d77-348c-4bf0-908f-22d402ee715c");

        invalidProductId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        invalidOfferId = UUID.fromString("22222222-2222-2222-2222-222222222222");
    }

    @Test
    public void testValidaCotacaoEOferta() {

        CotacaoSeguro cotacaoSeguro = new CotacaoSeguro();
        cotacaoSeguro.setProductId(validProductId);
        cotacaoSeguro.setIsActive(true);


        when(cotacaoRepository.findById(validProductId)).thenReturn(Optional.of(cotacaoSeguro));

        // Teste
        boolean result = cotacaoController.estaAtivo(validProductId, validOfferId);

        // Verificar resultado
        assertTrue(result);
    }
}
