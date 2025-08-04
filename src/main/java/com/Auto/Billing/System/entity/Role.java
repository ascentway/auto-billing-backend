package com.Auto.Billing.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="role")
@Getter
@Setter

public class Role {
    @Id
    private String roleId;
    private String roleName;
}
