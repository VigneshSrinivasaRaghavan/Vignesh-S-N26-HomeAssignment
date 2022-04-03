
package project.pojos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter

public class GetPetByIdResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("category")
    private CategoryResponse category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls = null;
    @JsonProperty("tags")
    private List<TagResponse> tags = null;
    @JsonProperty("status")
    private String status;
}
