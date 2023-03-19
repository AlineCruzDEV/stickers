package br.com.ada.users.user.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    @NotBlank(message = "Campo obrigatorio")
    private String street;
    @NotBlank(message = "Campo obrigatorio")
    private String neighborhood;
    @NotNull @Pattern(regexp = "\\d{8}")
    private String zipCode;
    @NotBlank(message = "Campo obrigatorio")
    private String city;
    @NotBlank(message = "Campo obrigatorio")
    String state;
    String complement;
    String number;
}
