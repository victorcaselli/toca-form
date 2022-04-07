package br.com.casellisoftware.tocaform.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "tb_config")
public class AppConfiguration implements Serializable {

    private static final long serialVersionUID = -7474599646240896610L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean visitorsScreen;
    private LocalDateTime updatedAt;
    private Boolean state;

}
