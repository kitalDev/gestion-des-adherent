package com.example.gestionAdherents.domain;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity  implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    @Column(
            name = "id", nullable = false,
            updatable = false,unique = true,
            length = 32
    )
    private String id;

    @CreatedDate
    @PastOrPresent
    @Column(
            name = "create_date",
            updatable = false,
            nullable = false
    )
    private Instant dateCreate = Instant.now();

    @LastModifiedDate
    @PastOrPresent
    @Column(
            name = "date_create",
            nullable = false,
            updatable = false
    )
    private Instant dateUpdate = Instant.now();
}
