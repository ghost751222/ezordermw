package com.macaron.ezordermw.controller;


import com.macaron.ezordermw.entity.OrderList;
import com.macaron.ezordermw.repository.OrderListRepository;
import com.macaron.ezordermw.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@ResponseBody
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = "/InsertOrderRecord", method = RequestMethod.GET)
    public String InsertOrderRecord(String orderNo, String customPhone) {

        String status ="1";
        try {
            OrderList orderList = new OrderList();
            orderList.setUuid(UUID.randomUUID().toString());
            orderList.setOrder_no(orderNo);
            orderList.setCustom_phone(customPhone);
            orderList.setSms_tag("1");
            orderList.setModify_time(LocalDateTime.now());
            orderList.setUpload_time(LocalDateTime.now());
            orderListRepository.save(orderList);
        } catch (Exception e) {
            status="0";
            logger.error("InsertOrderRecord Error ={0}",e);
        }



        return apiService.getApiStatusResponse("1",status);
    }


    @RequestMapping(value = "/GetCustomPhone", method = RequestMethod.GET)
    public String GetCustomPhone(String orderNo, String agentPhone) {

        String cPhone ="";
        try{
            List<OrderList> orderLists = orderListRepository.findByOrderNo(orderNo);
            for (OrderList orderList: orderLists) {
                cPhone = orderList.getCustom_phone();
                orderList.setAgent_phone(agentPhone);
                orderList.setModify_time(LocalDateTime.now());
                orderListRepository.save(orderList);

            }
        }catch (Exception e){
            cPhone="0";
            logger.error("GetCustomPhone Error ={0}",e);
        }



        return apiService.getApiCPhoneResponse("1",cPhone);
    }


    @RequestMapping(value = "/GetAgentPhone", method = RequestMethod.GET)
    public String GetAgentPhone(String customPhone) {

        String aPhone ="0";
        try{
            aPhone = orderListRepository.findByCustomPhoneLimit(customPhone);
        }catch (Exception e){
            aPhone="0";
            logger.error("GetAgentPhone Error ={0}",e);
        }
        return apiService.getApiAPhoneResponse("1",aPhone);
    }

    @RequestMapping(value = "/GetSMSState", method = RequestMethod.GET)
    public String GetSMSState(String customPhone) {

        String status ="0";
        try{
            Long count = orderListRepository.findByCustomPhoneTotal(customPhone);

            if(count > 0){
                status="2";
            }else if(count ==0){
                status="1";
            }

        }catch (Exception e){
            status="0";
            logger.error("GetSMSState Error ={0}",e);
        }
        return apiService.getApiStatusResponse("1",status);
    }


    @RequestMapping(value = "/MarkSMSTag", method = RequestMethod.GET)
    public String MarkSMSTag(String orderNo) {

        String status ="1";
        try{
           List<OrderList> orderLists = orderListRepository.findByOrderNo(orderNo);
            for (OrderList orderList: orderLists) {
                orderList.setSms_tag("2");
                orderList.setSms_time(LocalDateTime.now());
                orderList.setModify_time(LocalDateTime.now());
                orderListRepository.save(orderList);

            }

        }catch (Exception e){
            status="0";
            logger.error("MarkSMSTag Error ={0}",e);
        }
        return apiService.getApiStatusResponse("1",status);
    }
}
