package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
@Builder
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;
    private int wayNum;
    private String street;
    private int poBox;
    private String city;
    private String country;
}
