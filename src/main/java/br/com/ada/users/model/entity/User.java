package br.com.ada.users.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
