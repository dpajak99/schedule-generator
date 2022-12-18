package org.example.infra.dto.response.update_action_response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateActionResponseError implements UpdateActionResponse {
    private String message = "ERROR";
}
