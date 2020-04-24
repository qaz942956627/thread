package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * transfer_user
 * @author 
 */
@Data
public class TransferUser implements Serializable {
    private Long userId;

    private String userName;

    private Integer age;

    private BigDecimal money;

    private static final long serialVersionUID = 1L;
}