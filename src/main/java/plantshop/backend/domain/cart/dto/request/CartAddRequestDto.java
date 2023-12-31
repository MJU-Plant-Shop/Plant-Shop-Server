package plantshop.backend.domain.cart.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import plantshop.backend.domain.cart.entity.Cart;
import plantshop.backend.domain.member.entity.Member;
import plantshop.backend.domain.product.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartAddRequestDto {
    @NotNull(message = "상품 아이디를 입력해주세요.")
    @Schema(description = "상품 아이디", defaultValue = "1")
    private Long productId;

    @NotNull(message = "수량이 없습니다.")
    @Schema(description = "수량", defaultValue = "1")
    private Integer count;

    public Cart toEntity(Member member, Product product){
        return Cart.builder()
                .member(member)
                .product(product)
                .count(this.count)
                .build();
    }
}