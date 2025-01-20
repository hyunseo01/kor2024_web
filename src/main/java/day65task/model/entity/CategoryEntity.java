package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cate")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int cno; //카테고리넘버pk

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String cname; //카테고리이름

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<ProductEntity> productEntityList = new ArrayList<>();
}
