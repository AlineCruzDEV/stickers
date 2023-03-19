package br.com.ada.users.user.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;

    private String number;

    private String neighborhood;

    private String complement;

    private String city;

    private String state;

    private String zipCode;
}
