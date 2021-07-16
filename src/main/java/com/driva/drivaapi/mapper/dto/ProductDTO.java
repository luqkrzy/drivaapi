package com.driva.drivaapi.mapper.dto;

import com.driva.drivaapi.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @Positive(message = "product must be positive digit")
    private Long id;

    @NotNull(message = "product type id can't be blank")
    @Positive(message = "product type must be positive digit")
    private Long productTypeId;

    @NotNull(message = "student id can't be null")
    @Positive(message = "student must be positive digit")
    private Long studentId;

    @Positive(message = "hours should be a positive digit")
    @NotNull(message = "hours left  can't null")
    private Integer hoursLeft;

    @Column(name = "book_online")
    private Boolean bookOnline;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @NotNull(message = "price can't be null")
    @Positive(message = "price should be positive digit")
    private Double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.productTypeId = product.getProductTypeId().getId();
        this.studentId = product.getStudentId().getId();
        this.hoursLeft = product.getHoursLeft();
        this.bookOnline = product.getBookOnline();
        this.isPaid = product.getIsPaid();
        this.price = product.getPrice();
    }
}