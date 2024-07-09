package com.oracle.mapper;

import com.oracle.pojo.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> selectAllAddressByMember(Integer merberId);
}
