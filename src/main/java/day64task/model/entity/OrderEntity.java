package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sorder")
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class OrderEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono; //오더넘버

    @Column(columnDefinition = "int", nullable = false)
    private int ocount; //주문갯수

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity;
}
