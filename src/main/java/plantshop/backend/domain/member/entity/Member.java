package plantshop.backend.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import plantshop.backend.domain.AuditEntity;
import plantshop.backend.domain.cart.entity.Cart;
import plantshop.backend.domain.purchase.entity.Purchase;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    private List<Cart> cartList = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    private List<Purchase> purchaseList = new ArrayList<>();
}
