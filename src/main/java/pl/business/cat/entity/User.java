package pl.business.cat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USER_PICATE")
@Data
public class User {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private long userID;
    private String firstName;
    private String lastName;
    private String email;
     
    
}
