package com.seguradora.acme.acme;

import com.seguradora.acme.acme.service.CotacaoSeguroService;

public class CotacaoSeguroServiceTest {

        private final CotacaoSeguroService premiumValidationService = new CotacaoSeguroService();

        @Test
        public void testPremiumWithinRange_validPremium() {
            double totalMonthlyPremiumAmount = 75.25;
            double minPremium = 50.00;
            double maxPremium = 100.00;

            // Verifica se o prêmio mensal está dentro do intervalo
            boolean result = premiumValidationService.premioEstaEntreMaxEMin(totalMonthlyPremiumAmount, minPremium, maxPremium);
            assertTrue(result, "O prêmio mensal deveria estar dentro do intervalo.");
        }

        @Test
        public void testPremiumWithinRange_equalToMinPremium() {
            double totalMonthlyPremiumAmount = 50.00;
            double minPremium = 50.00;
            double maxPremium = 100.00;

            // Verifica se o prêmio mensal é igual ao valor mínimo permitido
            boolean result = premiumValidationService.premioEstaEntreMaxEMin(totalMonthlyPremiumAmount, minPremium, maxPremium);
            assertTrue(result, "O prêmio mensal deveria ser igual ao valor mínimo.");
        }

        @Test
        public void testPremiumWithinRange_equalToMaxPremium() {
            double totalMonthlyPremiumAmount = 100.00;
            double minPremium = 50.00;
            double maxPremium = 100.00;

            // Verifica se o prêmio mensal é igual ao valor máximo permitido
            boolean result = premiumValidationService.premioEstaEntreMaxEMin(totalMonthlyPremiumAmount, minPremium, maxPremium);
            assertTrue(result, "O prêmio mensal deveria ser igual ao valor máximo.");
        }

}
