package dto;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BudgetDTO {
    private Long id;
    private String category;
    private Double limitAmount;
    private Double spentAmount;
}

