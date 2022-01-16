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
                        "ck_9b2b1ea5e936c55b2b70c294acd47a17ab6ba502",
                        "cs_b231bf37934222f9bdbf1900aa9376fd7fe0cf4b"
                ),
                ApiVersionType.V3
        );
    }
}
