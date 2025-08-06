package com.Auto.Billing.System.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "caretakers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Caretaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long cid;
        private String name;
        private String email;
        private String address;
        private long mobileNo;
        private String password;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "bid")
        private Building building;
}
