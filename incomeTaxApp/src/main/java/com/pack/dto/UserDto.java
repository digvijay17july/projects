package com.pack.dto;

import com.pack.entity.UserEntity;

import javax.validation.constraints.NotNull;

public class UserDto extends UserEntity {

    private String userId;
    private String firstName;
    private String lastName;
    private int mobileNo;
    private String address;
    private double grossSalary;
    private boolean active;
    private String password;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    @NotNull
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    @NotNull
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    @NotNull
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getMobileNo() {
        return mobileNo;
    }

    @Override
    @NotNull
    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    @NotNull
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public double getGrossSalary() {
        return grossSalary;
    }

    @Override
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
