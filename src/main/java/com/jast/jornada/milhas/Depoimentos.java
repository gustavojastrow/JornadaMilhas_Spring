package com.jast.jornada.milhas;

import javax.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
@Table(name = "depoimentos")
@Entity(name= "Depoimento")

public class Depoimentos {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String foto;
    @NotBlank
    private String depoimento;
    @NotBlank
    private String autor;
}
