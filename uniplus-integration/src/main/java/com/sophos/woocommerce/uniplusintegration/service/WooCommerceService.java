package com.sophos.woocommerce.uniplusintegration.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.sophos.woocommerce.uniplusintegration.domain.vo.WooCommerceProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WooCommerceService {
    private final ObjectMapper mapper;
    private final WooCommerce wooCommerceService;

    public List<WooCommerceProductVO> getAllProducts() {
        var products = mapper.convertValue(
                wooCommerceService.getAll(EndpointBaseType.PRODUCTS.getValue()),
                WooCommerceProductVO[].class
        );
        return Arrays.asList(products)
                .stream()
                .filter(wooCommerceProductVO -> Strings.isNotBlank(wooCommerceProductVO.getSku()))
                .collect(Collectors.toList());
    }
}
