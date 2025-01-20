package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") //order로 할떄 오류생김
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono; //주문 넘버

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "uno")
    private UserEntity userEntity;
}
