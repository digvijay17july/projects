package com.dto;


import com.entity.UserEntity;

public class UserDto extends UserEntity {

    private Long _id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String address;
    private double grossSalary;
    private boolean active;
    private String password;
    private String username;
    private int age;

    public UserDto() {
    }



    public UserDto(Long _id, String firstName, String lastName, String mobileNo, String address, double grossSalary, boolean active, String password, String username, int age, String userId1, String firstName1, String lastName1, String mobileNo1, String address1, double grossSalary1, boolean active1, String password1, String username1, int age1) {
        super(_id, firstName, lastName, mobileNo, address, grossSalary, active, password, username, age);
        this._id = _id;
        this.firstName = firstName1;
        this.lastName = lastName1;
        this.mobileNo = mobileNo1;
        this.address = address1;
        this.grossSalary = grossSalary1;
        this.active = active1;
        this.password = password1;
        this.username = username1;
        this.age = age1;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username=username;
    }

    @Override
    public Long get_id() {
        return _id;
    }

    @Override
    public void set_id(Long _id) {
        this._id = _id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getMobileNo() {
        return mobileNo;
    }

    @Override
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
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
