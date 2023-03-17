package com.adatech.stickers.user.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @NotBlank(message = "O campo documento é obrigatório")
    private String document;

}
