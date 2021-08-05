package org.openpaas.paasta.portal.web.admin.service;

import org.openpaas.paasta.portal.web.admin.common.Common;
import org.openpaas.paasta.portal.web.admin.common.Constants;
import org.openpaas.paasta.portal.web.admin.common.User;
import org.openpaas.paasta.portal.web.admin.common.UserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 공통 기능을 구현한 서비스 클래스이다.
 *
 * @author 김도준
 * @version 1.0
 * @since 2016.07.07 최초작성
 */
@Service
public class CommonService extends Common {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonService.class);
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String CF_AUTHORIZATION_HEADER_KEY = "cf-Authorization";
//    private final RestTemplate restTemplate;


    RestTemplate restTemplate;


    private String apiUrl;

    @Value("${paasta.portal.api.authorization.base64}")
    private String base64Authorization;

    @Value("${paasta.portal.api.zuulUrl.cfapi}")
    private String cfApiUrl;


    @Value("${paasta.portal.api.zuulUrl.commonapi}")
    private String commonApiUrl;

    @Value("${paasta.portal.api.zuulUrl.storageapi}")
    private String storageApiUrl;

    @Value("${paasta.portal.storageapi.type}")
    private String storageApiType;


    /**
     * REST TEMPLATE 처리(통합)
     *
     * @param endpoint       the req url
     * @param httpMethod     the http method
     * @param param          the rest api param
     * @param api            the Api target
     * @param responseType   the ResponseType
     * @return <T> ResponseEntity<T>
     */

    public <T> ResponseEntity<T> procApiRestTemplate(String endpoint, HttpMethod httpMethod, Object param, String api, Class<T> responseType) {
            restTemplate = new RestTemplate();
            HttpHeaders reqHeaders = new HttpHeaders();
            StringBuffer req = new StringBuffer();
            LOGGER.info("ENDPOINT ::::" +  endpoint);
            switch(api){
                case Constants.CF_API :
                case Constants.CF_API_V3:
                case Constants.COMMON_API :
                case Constants.STORAGE_API :
                    switch (api){
                        case Constants.CF_API :  req.append(cfApiUrl + endpoint); break;
                        case Constants.COMMON_API :  req.append(commonApiUrl + endpoint); break;
                        case Constants.STORAGE_API :  req.append(storageApiUrl + "/v2/" + storageApiType + '/' + endpoint); break;
                    }
                    reqHeaders.add(AUTHORIZATION_HEADER_KEY, base64Authorization);
                    reqHeaders.add(CF_AUTHORIZATION_HEADER_KEY, getToken());
                    break;
                default: new Throwable("API 구문 오류");
            }
            HttpEntity<Object> reqEntity = new HttpEntity<>(param, reqHeaders);
        return restTemplate.exchange(req.toString(), httpMethod, reqEntity, responseType);
    }


    /**
     * REST TEMPLATE 처리(통합)
     *
     * @param endpoint       the req url
     * @param httpMethod     the http method
     * @param param          the rest api param
     * @param responseType   the ResponseType
     * @return <T> ResponseEntity<T>
     */

    public <T> ResponseEntity<T> procLoginRestTemplate(String endpoint, HttpMethod httpMethod, Object param, Class<T> responseType) {
        restTemplate = new RestTemplate();
        HttpHeaders reqHeaders = new HttpHeaders();
        StringBuffer req = new StringBuffer();
        LOGGER.info("로그인");
        req.append(cfApiUrl + endpoint);
        reqHeaders.add(AUTHORIZATION_HEADER_KEY, base64Authorization);
        HttpEntity<Object> reqEntity = new HttpEntity<>(param, reqHeaders);
        return restTemplate.exchange(req.toString(), httpMethod, reqEntity, responseType);
    }


    /**
     * USER ID를 조회한다.
     *
     * @return user id
     */
    public String getUserId() {
        UserDetails userList = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userList.getUsername();
    }


    /**
     * USER ID를 설정한다.
     *
     * @param classObject the class object
     * @return the object
     * @throws Exception the exception
     */
    public Object setUserId(Object classObject) throws Exception {
        String methodName = "setUserId";
        Method method = classObject.getClass().getMethod(methodName, String.class);
        Object[] paramObject = new Object[]{this.getUserId()};

        method.invoke(classObject, paramObject);

        return classObject;
    }
}
