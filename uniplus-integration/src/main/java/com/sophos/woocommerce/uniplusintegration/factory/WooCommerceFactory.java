package com.sophos.woocommerce.uniplusintegration.factory;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WooCommerceFactory {
    @Bean
    public WooCommerce makeWoocommerceFactory(){
        return new WooCommerceAPI(
                new OAuthConfig(
                        "https://catalogo.rfldesigner.com.br",
                        "ck_****************************************",
                        "cs_****************************************"
                ),
                ApiVersionType.V3
        );
    }
}
