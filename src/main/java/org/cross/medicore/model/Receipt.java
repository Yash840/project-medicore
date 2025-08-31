package org.cross.medicore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt extends Document{
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Service> services;
    private double taxRate = 5;
    private double discount;

    @Transient
    private double billAmount;
    @Transient
    private double taxAmount;
    @Transient
    private double discountAmount;
    @Transient
    private double netBillingAmount;

    @PostPersist
    @PostUpdate
    @PostLoad
    private void calculateBillAmounts(){
        if(services == null){
            return ;
        }

        billAmount = this.services.stream()
                .mapToDouble(Service::getCharges)
                .sum();
        taxAmount = billAmount * (taxRate / 100);
        discountAmount = billAmount * (discount / 100);
        netBillingAmount = billAmount + taxAmount - discountAmount;
    }
}
