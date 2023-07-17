package com.HMRS.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")

public class Employee implements Serializable{
    /**
     * auto generates an employee id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;
    /**
     * employee first name
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * employee last name
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * employee email, will probably be used for authentication
     */
    @Column(name="email")
    private String email;
    /**
     * employee home address
     */
    @Column(name="address")
    private String address;
    /**
     * employee job Id, this determines pay
     */
    @Column(name="job_Id")
    private int jobId;
    /**
     * employee benefits package currently enrolled in
     */
    @Column(name="benefitPAckageId")
    private int benefitPackageId;

    /**
     * gets employee id
     * @return long sid
     */
    public long getSid() {
        return sid;
    }

    /**
     * sets the employee id
     * @param sid
     */
    public void setSid(long sid) {
        this.sid = sid;
    }

    /**
     * employee first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets employee first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets employee last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets last name, string input
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getBenefitPackageId() {
        return benefitPackageId;
    }

    public void setBenefitPackageId(int benefitPackageId) {
        this.benefitPackageId = benefitPackageId;
    }

    /*@ManyToMany(cascade = CascadeType.MERGE)

    @JoinTable(name = "training_employee",
            joinColumns = {@JoinColumn(name = "sid")},
            inverseJoinColumns = {@JoinColumn(name = "id")})*/


}
