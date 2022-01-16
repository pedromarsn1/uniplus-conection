package com.sophos.woocommerce.uniplusintegration.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WooCommerceProductVO {
    private String json;
    private Long id;
    private String name;
    private String slug;
    private String permalink;
    private String v_type;
    private String status;
    private Boolean featured;
    private String catalog_visibility;
    private String description;
    private String short_description;
    private String sku;
    private String price;
    private String regular_price;
    private String sale_price;
    private String price_html;
    private Boolean on_sale;
    private Boolean purchasable;
    private Integer total_sales;
    private Boolean v_virtual;
    private Boolean downloadable;
    private Integer download_limit;
    private Integer download_expiry;
    private String external_url;
    private String button_text;
    private String tax_status;
    private String tax_class;
    private Boolean manage_stock;
    private String stock_quantity;
    private String stock_status;
    private String backorders;
    private Boolean backorders_allowed;
    private Boolean backordered;
    private Boolean sold_individually;
    private String weight;
    private String dimensionsLength;
    private String dimensionsWidth;
    private String dimensionsHeight;
    private Boolean shipping_required;
    private Boolean shipping_taxable;
    private String shipping_class;
    private Integer shipping_class_id;
    private Boolean reviews_allowed;
    private String average_rating;
    private Integer rating_count;
    private Integer parent_id;
    private String purchase_note;
    private Integer menu_order;
    private Integer j;
    private Integer count_j;
    private Integer intVal;
    private String src;
    private String alt;
    private Integer position;
    private Boolean visible;
    private Boolean variation;
    private Integer k;
    private Integer count_k;
    private String strVal;
    private String v_option;
    private String href;
    private String date_created;
    private String date_created_gmt;
    private String date_modified;
    private String date_modified_gmt;
    private String date_on_sale_from;
    private String date_on_sale_from_gmt;
    private String date_on_sale_to;
    private String date_on_sale_to_gmt;
    private List<MetaDataVO> meta_data;
}
