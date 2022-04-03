package project.pojos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter

public class CreateOrderResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("petId")
    private Integer petId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("status")
    private String status;
    @JsonProperty("complete")
    private Boolean complete;
}
