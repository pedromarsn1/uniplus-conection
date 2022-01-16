package com.sophos.woocommerce.uniplusintegration.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaDataVO {
    private Integer id;
    private String key;
    private String value;
}
