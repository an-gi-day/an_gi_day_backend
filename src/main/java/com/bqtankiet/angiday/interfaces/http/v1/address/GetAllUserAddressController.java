package com.bqtankiet.angiday.interfaces.http.v1.address;

import com.bqtankiet.angiday.application.address.usecase.getAllUserAddress;
import com.bqtankiet.angiday.application.user.usecase.GetCurrentUserId;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllUserAddressController {
    private final GetCurrentUserId getCurrentUserId;
    private final getAllUserAddress getAllUserAddress;

    @Autowired
    public GetAllUserAddressController(GetCurrentUserId getCurrentUserId, getAllUserAddress getAllUserAddress) {
        this.getCurrentUserId = getCurrentUserId;
        this.getAllUserAddress = getAllUserAddress;
    }

    @GetMapping("/api/v1/users/me/address")
    public ResponseEntity<?> getAllAddress(){
        String userId = getCurrentUserId.call();
        Long longUserId = Long.parseLong(userId);
        var listAddress = getAllUserAddress.execute(longUserId);
        return ResponseEntity.ok().body(ApiResponse.success(listAddress));
    }

}
