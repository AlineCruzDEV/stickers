package br.com.ada.users.user.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateDTO {

    @NotBlank(message = "Name field is missing or blank.")
    private String name;

    @NotBlank(message = "Name field is missing or blank.")
    private String document;

    @Email
    @NotBlank(message = "Name field is missing or blank.")
    private String email;
    
//    @NotNull(message = "At least one address must be informed.")
//    private AddressCreationDTO address;

}
