package com.pizzas.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderDetail;
    
    @OneToOne
    @MapsId("idPurchaseOrder")
    @JoinColumn(name = "id_purchase_order")
    private PurchaseOrder purchaseOrder;
    @ManyToMany
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private Set<Product> productSet; 
    
    private short quantity;
    
    
    
}
