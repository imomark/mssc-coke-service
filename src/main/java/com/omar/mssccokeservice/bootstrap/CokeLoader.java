package com.omar.mssccokeservice.bootstrap;

import com.omar.mssccokeservice.domain.Coke;
import com.omar.mssccokeservice.repositories.CokeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CokeLoader implements CommandLineRunner {
    private final CokeRepository cokeRepository;

    CokeLoader(CokeRepository cokeRepository){
        this.cokeRepository = cokeRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadCokeObjects();
    }

    private void loadCokeObjects() {
        if(cokeRepository.count() == 0){
            cokeRepository.save(Coke.builder()
                    .cokeName("Pepsi")
                    .cokeStyle("IPA")
                    .quantityToCoke(200)
                    .minOnHand(12)
                    .upc(337L)
                    .price(new BigDecimal(12.95))
                    .build());
            cokeRepository.save(Coke.builder()
                    .cokeName("Thumps UP")
                    .cokeStyle("BLACK")
                    .quantityToCoke(100)
                    .minOnHand(12)
                    .upc(338L)
                    .price(new BigDecimal(11.95))
                    .build());
        }
    }
}
