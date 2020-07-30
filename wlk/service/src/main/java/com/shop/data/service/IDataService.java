package com.shop.data.service;

import com.shop.dto.UserAccountRequest;
import com.shop.vo.UserAccountVO;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface IDataService {



    public UserAccountVO get(UserAccountRequest accountRequest);

}
