package com.sophos.woocommerce.uniplusintegration.service;

import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.sophos.woocommerce.uniplusintegration.domain.vo.MetaDataVO;
import com.sophos.woocommerce.uniplusintegration.domain.vo.WooCommerceProductVO;
import com.sophos.woocommerce.uniplusintegration.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoWooCommerceService {
    private final ProdutoRepository produtoRepository;
    private final WooCommerceService wooCommerceService;
    private final WooCommerce wooCommerce;

    public void atualizarProdutosWoocommerce() {
        wooCommerceService.getAllProducts().forEach(wooCommerceProductVO -> {
            var produtoUniplus = produtoRepository
                    .findFirstByCodigo(wooCommerceProductVO.getSku())
                    .orElseThrow(RuntimeException::new);

            Map<String, Object> productInfoUpdate = new HashMap<>();
            productInfoUpdate.put("name", produtoUniplus.getNomeEcf());
            productInfoUpdate.put("regular_price", produtoUniplus.getPreco().toString());
            var priceTypeOne = String.format("%,.2f", produtoUniplus.getPrecoPautaQuatro().setScale(2, RoundingMode.HALF_EVEN));
            var metaDataProduct = MetaDataVO.builder()
                    .id(this.getPriceTypesOneMetaDataId(wooCommerceProductVO))
                    .key("_price_types_1")
                    .value(priceTypeOne)
                    .build();
            productInfoUpdate.put("meta_data", List.of(metaDataProduct));
            Map<String, Object> produto = wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), wooCommerceProductVO.getId().intValue(), productInfoUpdate);
            log.info("O produto com id: {}, nome: {}, código: {} e preço: {} foi atualizado.",
                    wooCommerceProductVO.getId().toString(),
                    produtoUniplus.getNomeEcf(),
                    produtoUniplus.getCodigo(),
                    priceTypeOne
            );
        });
    }
    private Integer getPriceTypesOneMetaDataId(WooCommerceProductVO wooCommerceProductVO){
        return wooCommerceProductVO.getMeta_data()
                .stream()
                .filter(metaDataVO -> metaDataVO.getKey().equalsIgnoreCase("_price_types_1"))
                .map(MetaDataVO::getId)
                .findFirst()
                .orElse(null);

    }

}
