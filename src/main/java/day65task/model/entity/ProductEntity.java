package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pro")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; //제품 넘버
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String pname; //제품이름

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

}
