package sdu.shopWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long id;

    private double sumPrice;

    private UsersDTO usersDTO;

    private List<ProductDTO> productsDTO;
}
