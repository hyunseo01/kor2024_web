package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderDetail")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int odno; //주문상세 넘버

    @Column(columnDefinition = "int", nullable = false)
    private int odcount; //제품수량

    @ManyToOne
    @JoinColumn(name = "ono")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "sellerno")
    private UserEntity seller;

    @ManyToOne
    @JoinColumn(name = "buyerno")
    private UserEntity buyer;
}
