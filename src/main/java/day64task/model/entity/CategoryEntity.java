package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter@Setter@Builder@ToString@NoArgsConstructor@AllArgsConstructor
public class CategoryEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;//카테고리 넘버
    @Column(columnDefinition = "varchar(50)" , unique = true , nullable = false)
    private String cname; //카테고리 이름

    //양뱡향
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<ProductEntity> entities = new ArrayList<>();

}
