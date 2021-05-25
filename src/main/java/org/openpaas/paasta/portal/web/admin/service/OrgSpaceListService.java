package org.openpaas.paasta.portal.web.admin.service;

import org.openpaas.paasta.portal.web.admin.common.Common;
import org.openpaas.paasta.portal.web.admin.common.Constants;
import org.openpaas.paasta.portal.web.admin.controller.OrgSpaceListController;
import org.openpaas.paasta.portal.web.admin.model.Org;
import org.openpaas.paasta.portal.web.admin.model.Space;
import org.openpaas.paasta.portal.web.admin.model.UserManagement;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by MIN on 2018-03-22.
 */
@Service
public class OrgSpaceListService extends Common {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrgSpaceListService.class);

    /**
     * Gets org space list main.
     *
     * @return the org space list main
     */
    @Autowired
    CommonService commonService;

    public ModelAndView getOrgSpaceListMain() {
        return new ModelAndView() {{
            setViewName("/orgSpaceList/orgSpaceListMain");
        }};
    }


    /**
     * admin 유저로 접근 가능한 조직 목록(모든 조직 목록)을 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     * @throws Exception the exception
     */
//    public Map<String, Object> getOrgsForAdmin(String reqUrl, HttpMethod httpMethod, String param, String reqToken) throws Exception {
//        return commonService.procCfApiRestTemplate(Constants.V3_URL + reqUrl, httpMethod, param, reqToken);
//    }

    public Map<String, Object> getOrgsForAdmin(String reqUrl, HttpMethod httpMethod, Object obj) throws Exception {
        return commonService.procApiRestTemplate(Constants.V3_URL + reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     * admin 유저로 접근 가능한 모든 공간목록을 조회한다.
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @param obj
     * @return
     * @throws Exception
     */
    public Map<String, Object> getAllSpacesForAdmin(String reqUrl,HttpMethod httpMethod,Object obj) throws Exception{
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     * admin 유저로 접근 가능한 영역 목록(모든 영역 목록)을 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     * @throws Exception the exception
     */
    public Map<String, Object> getSpacesForAdmin(String reqUrl, HttpMethod httpMethod, Object obj) throws Exception {
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 조직 요약 정보를 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     */
    public Map<String, Object> getOrgSummary(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }


    /**
     * 조직 이름으로 조직의 정보를 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     */
    public Map<String, Object> getOrgQuota(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 운영자 포털에서 조직이름과 할당량을 변경한다.
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @return
     */
    public Map renameOrgForAdmin (String reqUrl,HttpMethod httpMethod,Map org){
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, org, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 운영자 포털에서 공간이름과할당량을 변경한다..
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @return
     */
    public Map renameSpaceQuotaForAdmin (String reqUrl,HttpMethod httpMethod,Map space){
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, space, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 운영자 포털에서 공간명을 변경한다..
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @return
     */
    public Map renameSpaceForAdmin (String reqUrl,HttpMethod httpMethod,Map space){
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, space, Constants.CF_API, Map.class).getBody();
    }


    /**
     * 운영자 포털에서 할당량을 변경한다.
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @return
     */
    public Map qutaoSpaceForAdmin (String reqUrl,HttpMethod httpMethod,Map space){
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, space, Constants.CF_API, Map.class).getBody();
    }

    /**
     *
     * 운영자 포털에서 조직을 삭제한다.
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @return
     */
    public Map deleteOrgForAdmin(String reqUrl,HttpMethod httpMethod){
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, null, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 영역 요약 정보를 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     */
    public Map<String, Object> getSpaceSummary(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(Constants.V3_URL+reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 영역 쿼터 정보를 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     */
    public Map<String, Object> getSpaceQuota(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(Constants.V3_URL + reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     * 특정 영역을 선택하여 영역을 조회한다.
     *
     * @param reqUrl     RestUrl
     * @param httpMethod httpMethod
     * @return Map (자바 Map 클래스)
     */
    public Map<String, Object> getSpace(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(Constants.V3_URL + reqUrl, httpMethod, obj, Constants.CF_API, Map.class).getBody();
    }

    /**
     *
     * 운영자 포털에서 조직을 생성한다.
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @param param
     * @return
     */
    public Map createOrgForAdmin(String reqUrl,HttpMethod httpMethod,Map param){
        return commonService.procApiRestTemplate(Constants.V3_URL + reqUrl, httpMethod, param, Constants.CF_API, Map.class).getBody();
    }

    /**
     *
     * 운영자 포털에서 공간을 생성한다.
     *
     * @param key
     * @param reqUrl
     * @param httpMethod
     * @param
     * @return
     */
    public Map createSpaceForAdmin(String reqUrl,HttpMethod httpMethod,Map param){
        return commonService.procApiRestTemplate(Constants.V3_URL + reqUrl, httpMethod, param, Constants.CF_API, Map.class).getBody();
    }

}
