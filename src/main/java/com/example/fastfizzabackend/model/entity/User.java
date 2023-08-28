package com.example.fastfizzabackend.model.entity;

import com.example.fastfizzabackend.utils.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String username;

    @Column(length = 10, nullable = false)
    private String phone;

    @Column(length = 200, nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", roleName=" + roleName +
            '}';
    }
}