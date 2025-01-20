package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int uno; //회원번호pk

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String uname; //회원이름
    @Column(columnDefinition = "varchar(30)", unique = true ,nullable = false)
    private String uid; //회원아이디
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String upwd; //회원비밀번호
    @Column(columnDefinition = "int", unique = true, nullable = false)
    private int uphone; //회원전화번호
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private int uaddress; //회원주소

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderDetailEntity> orderDetailEntityList_buyer = new ArrayList<>();

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderDetailEntity> orderDetailEntityList_seller = new ArrayList<>();

}
