package com.dwuthk.practice.ehcache.controller;

import com.dwuthk.practice.ehcache.service.SampleService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HK
 */
@RestController
public class SampleController {

    @Autowired
    private SampleService service;

    /**
     * Get Non-Cached Data From ServiceLayer Generated
     *
     * @param param
     * @return
     */
    @RequestMapping(
            value = "getNormal1",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Map getNormalNonCache(@RequestParam(value = "param", required = true) String param) {

        return service.getNormalDataNonCaching(param);
    }

    /**
     * Get Cached Data From ServiceLayer Generated
     *
     * @param param
     * @return
     */
    @RequestMapping(
            value = "getNormal2",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Map getNormalCache(@RequestParam(value = "param", required = true) String param) {

        return service.getNormalDataCaching(param);
    }

    /**
     * Get Cached Data From ServiceLayer Generated By Multiple Parameter
     *
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @RequestMapping(
            value = "getNormal3",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Map getNormalCacheMultipleParam(
            @RequestParam(value = "param1", required = true) String param1,
            @RequestParam(value = "param2", required = true) String param2,
            @RequestParam(value = "param3", required = false) String param3
    ) {

        return service.getNormalDataDefaultKeyStrategy(param1, param2, param3);
    }
    
    
    /**
     * Get Non-Cached Data From ServiceLayer Generated And Erase Cached Data By Key
     *
     * @param param
     * @return
     */
    @RequestMapping(
            value = "getNormal4",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Map getNormalNonCacheErase(
            @RequestParam(value = "param", required = true) String param
    ) {

        return service.getNormalDataEraseCache(param);
    }
    

    /**
     * Get Non-Cached Data From Database through Myabatis Mapper
     *
     * @param param
     * @return
     */
    @RequestMapping(
            value = "getMybatis1",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public com.dwuthk.practice.ehcache.model.Character getMybatisNonCache(@RequestParam(value = "param", required = true) Long param) {

        return service.getMybatisDataNonCaching(param);
    }

    /**
     * Get Cached Data From Database through Myabatis Mapper
     *
     * @param param
     * @return
     */
    @RequestMapping(
            value = "getMybatis2",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public com.dwuthk.practice.ehcache.model.Character getMybatisCache(@RequestParam(value = "param", required = true) Long param) {

        return service.getMybatisDataCaching(param);
    }

}
