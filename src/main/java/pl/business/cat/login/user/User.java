package pl.business.cat.login.user;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.Data;

@Component
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
    private String userName;
    private String password;
     
    
}
