package com.sophos.woocommerce.uniplusintegration.job;

import com.sophos.woocommerce.uniplusintegration.service.ProdutoWooCommerceService;
import com.sophos.woocommerce.uniplusintegration.service.WooCommerceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class UniplusWooCommerceJob {

    private final ProdutoWooCommerceService produtoWooCommerceService;

    @Scheduled(cron = "0 * * * * *")
    public void updateProductsJob() {
        log.info("Job started at: {}", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        produtoWooCommerceService.atualizarProdutosWoocommerce();
    }

}
