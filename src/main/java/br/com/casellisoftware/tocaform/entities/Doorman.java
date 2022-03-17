package br.com.casellisoftware.tocaform.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_doorman")
public class Doorman implements Serializable {

    private static final long serialVersionUID = 2679086004932738350L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean free;
    private LocalDateTime createAt;


    public Doorman(){
        free = false;
    }
}
