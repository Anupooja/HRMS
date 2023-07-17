package com.HMRS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="Benefits")
public class Benefits implements Serializable {
    /**
     * benefits package Id is an int value, only a couple packages available
     */
    @Id
    @Column(name="benefitPackageId")
    private int benefitId;
    /**
     * benefit package name, ex: Gold, Silver
     */
    @Column(name="benefitPackageName")
    private String benefitPackageName;

    /**
     *
     * @return int that is benefit package Id
     */
    public int getBenefitId() {
        return benefitId;
    }

    /**
     * sets the Id of a benefits package
     * @param benefitId
     */
    public void setBenefitId(int benefitId) {
        this.benefitId = benefitId;
    }

    /**
     * will return the name of benefits package
     * @return String Name
     */
    public String getBenefitPackageName() {
        return benefitPackageName;
    }

    /**
     * sets name of benefit package
     * @param benefitPackageName
     */
    public void setBenefitPackageName(String benefitPackageName) {
        this.benefitPackageName = benefitPackageName;
    }
}
