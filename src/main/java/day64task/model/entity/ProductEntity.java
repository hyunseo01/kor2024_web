package day64task.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@DynamicInsert
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class ProductEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; //제품 번호

    @Column(columnDefinition = "varchar(50)" , nullable = false)
    private String pname;//제품명

    @Column(columnDefinition = "int" , nullable = false)
    private String pprice;//제품가격

    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();
}
