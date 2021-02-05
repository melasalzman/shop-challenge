package com.meli.shop.purchase.API.v1.DTO.user;

public class UserFilterDTO {
    private String province;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public UserFilterDTO(String province) {
        this.province = province;
    }

    public UserFilterDTO() {
    }
}
