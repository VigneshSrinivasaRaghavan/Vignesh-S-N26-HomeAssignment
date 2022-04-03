
package project.pojos.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor  @NoArgsConstructor @Builder @Getter @Setter

public class TagRequest {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}
