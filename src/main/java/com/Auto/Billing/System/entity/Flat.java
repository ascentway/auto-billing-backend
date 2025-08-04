package com.Auto.Billing.System.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int flatId;

    @Column(nullable = false)
    private String flatNo;

    @Column(nullable = false)
    private String flatType;

    @Column(nullable = false)
    private int maxTenants;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private boolean isOccupied = false;

    @ManyToOne
    @JoinColumn(name = "bid", nullable= false)
    private Building building;

    @OneToMany(mappedBy ="flat", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Tenant> tenants = new ArrayList<>();

    public void setFlatType(String flatType){
        this.flatType = flatType.toUpperCase();
        this.maxTenants = resolveMaxTenants(this.flatType);
    }

    private int resolveMaxTenants(String flatType){
        return switch (flatType){
            case "1BHK" -> 1;
            case "2BHK" -> 2;
            case "3BHK" -> 3;
            case "4BHK" -> 4;
            default -> 1;
        };
    }
}
