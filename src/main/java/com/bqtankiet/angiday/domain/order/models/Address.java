package com.bqtankiet.angiday.domain.order.models;

import java.util.Objects;

public class Address {
    private String addressId;
    private String phone;
    private double longitude;
    private double latitude;
    private String location;
    private String name;
    private boolean snapshot;

    public Address() {
    }

    public Address(String addressId, String phone, double longitude, double latitude, String location, String name, boolean snapshot) {
        this.addressId = addressId;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.location = location;
        this.name = name;
        this.snapshot = snapshot;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Double.compare(longitude, address.longitude) == 0 && Double.compare(latitude, address.latitude) == 0 && snapshot == address.snapshot && Objects.equals(addressId, address.addressId) && Objects.equals(phone, address.phone) && Objects.equals(location, address.location) && Objects.equals(name, address.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, phone, longitude, latitude, location, name, snapshot);
    }

    // getters & setters

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    public void setSnapshot(boolean snapshot) {
        this.snapshot = snapshot;
    }
}

