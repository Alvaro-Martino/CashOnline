package api.muestra.cash.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "loan")
@Data
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @Column(nullable = false)
    private Float total;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

}
