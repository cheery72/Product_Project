package com.project.product.domain.store;

import com.project.product.domain.order.Order;
import com.project.product.domain.review.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String city;

    private String gu;

    private String dong;

    private String detail;
    
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Store(Long id, String city, String gu, String dong, String detail, List<Review> reviews, List<Order> orders) {
        this.id = id;
        this.city = city;
        this.gu = gu;
        this.dong = dong;
        this.detail = detail;
        this.reviews = reviews;
        this.orders = orders;
    }
}
