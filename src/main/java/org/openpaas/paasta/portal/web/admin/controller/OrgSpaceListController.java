package org.openpaas.paasta.portal.web.admin.controller;

import org.openpaas.paasta.portal.web.admin.common.Common;
import org.openpaas.paasta.portal.web.admin.common.Constants;
import org.openpaas.paasta.portal.web.admin.common.User;
import org.openpaas.paasta.portal.web.admin.model.UserManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 도메인 정보 조회, 추가, 삭제 등 도메인 관리의 API 를 호출 받는 컨트롤러이다.
 *
 * @version 1.0
 * @since 2016 -09-06
 */
@RestController
public class OrgSpaceListController extends Common {

    private final String V2_URL = "/v2";

    private static final Logger LOGGER = LoggerFactory.getLogger(OrgSpaceListController.class);
    /**
     * Gets org space list main.
     *
     * @return the org space list main
     */
    @GetMapping("/orgspacelist")
    public ModelAndView getOrgSpaceListMain() {
        return orgSpaceListService.getOrgSpaceListMain();
    }


    //----------------------------------------------------------------------------------------------------------//

    /**
     * 조직 정보를 조회한다.
     *
     * @return Map
     */
    @GetMapping(value = {Constants.V2_URL + "/orgs/{orgId}"})
    @ResponseBody
    public Map<String, Object> getOrg(@PathVariable String orgId, HttpServletRequest request) {
        return commonService.procApiRestTemplate(Constants.V3_URL + "/orgs/" + orgId, HttpMethod.GET, null, Constants.CF_API, Map.class).getBody();
    }

    /**
     * admin 유저로 접근 가능한 조직 목록(모든 조직 목록)을 조회한다.
     *
     * @return Map (자바 Map 클래스)
     * @throws Exception the exception
     * @thorws Exception
     */
//    @GetMapping(V2_URL + "/orgs")
//    public Map<String, Object> getOrgsForAdmin( HttpServletRequest request) throws Exception {
//
//        LOGGER.info("!!!!!!!!!!!!!!!!!!! "  +key);
//        return orgSpaceListService.getOrgsForAdmin("/orgs-admin", HttpMethod.GET, null, getToken());
//    }
    @GetMapping(V2_URL + "/orgs")
    public Map<String, Object> getOrgsForAdmin( HttpServletRequest request) throws Exception {
        return orgSpaceListService.getOrgsForAdmin("/orgs-admin", HttpMethod.GET, null);
    }

    /**
     * admin 유저로 접근 가능한 모든 공간목록을 조회한다.
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(V2_URL + "/spaces2")
    public Map<String,Object> getSpacesForAdmin( HttpServletRequest request) throws Exception{
        String key=request.getParameter("key");
        return orgSpaceListService.getAllSpacesForAdmin("/spaces-admin",HttpMethod.GET,null);
    }

    /**
     * admin 유저로 접근 가능한 영역 목록(모든 영역 목록)을 조회한다.
     *
     * @param orgid org id
     * @return Map (자바 Map 클래스)
     * @throws Exception the exception
     */
    @GetMapping(V2_URL + "/orgs/{orgid}/spaces")
    public Map<String, Object> getSpacesForAdmin(@PathVariable String orgid, HttpServletRequest request) throws Exception {
        return orgSpaceListService.getSpacesForAdmin("/orgs/" + orgid + "/spaces-admin", HttpMethod.GET,null);
    }

    /**
     * 조직 요약 정보를 조회한다.
     *
     * @param orgid org id
     * @return Org 조직 객체
     */
    @GetMapping(V2_URL + "/orgs/{orgid}/summary")
    public Map<String, Object> getOrgSummary(@PathVariable String orgid, HttpServletRequest request) {
        return orgSpaceListService.getOrgSummary("/orgs/" + orgid + "/summary-admin", HttpMethod.GET, null);
    }


    /**
     * 조직 이름으로 조직의 정보를 조회한다.
     *
     * @param orgid orgid
     * @return Org 조직 객체
     */
    @GetMapping(V2_URL + "/orgs/{orgid}/quota")
    public Map<String, Object> getOrgQuota(@PathVariable String orgid, HttpServletRequest request) {
        return orgSpaceListService.getOrgQuota("/orgs/" + orgid + "/quota-admin", HttpMethod.GET, null);
    }

    /**
     * 운영자 포털에서 조직이름과 할당량을 변경한다.
     *
     * @param org
     * @param request
     * @return
     */
    @PutMapping(Constants.V2_URL + "/organization-admin")
    public Map renameOrgForAdmin(@RequestBody Map org, HttpServletRequest request){
        String key=request.getParameter("key");
        return orgSpaceListService.renameOrgForAdmin("/organization-admin",HttpMethod.PUT,org);
    }

    /**
     * 운영자 포털에서 공간이름과할당량을 변경한다.
     *
     * @param space
     * @param request
     * @return
     */
    @PutMapping(Constants.V2_URL + "/space-admin")
    public Map renameSpaceQuotaForAdmin(@RequestBody Map space, HttpServletRequest request){
        String key=request.getParameter("key");
        return orgSpaceListService.renameSpaceQuotaForAdmin("/space-admin",HttpMethod.PUT,space);
    }

    /**
     * 운영자 포털에서 공간명을 변경한다.
     *
     * @param space
     * @param request
     * @return
     */
    @PutMapping(Constants.V2_URL + "/space-name-admin")
    public Map renameSpaceForAdmin(@RequestBody Map space, HttpServletRequest request){
        String key=request.getParameter("key");
        return orgSpaceListService.renameSpaceForAdmin("/space-admin",HttpMethod.PUT,space);
    }

    /**
     * 운영자 포털에서 할당량을 변경한다.
     *
     * @param space
     * @param request
     * @return
     */
    @PutMapping(Constants.V2_URL + "/space-quota-admin")
    public Map qutaoSpaceForAdmin(@RequestBody Map space, HttpServletRequest request){
        String key=request.getParameter("key");
        return orgSpaceListService.qutaoSpaceForAdmin("/space-quota-admin",HttpMethod.PUT,space);
    }

    /**
     * 운영자 포털에서 조직을 삭제한다. (Org Delete)
     *
     * @param guid      the organization id (guid)
     */
    @DeleteMapping(Constants.V2_URL + "/organizations-admin/{guid}")
    public Map deleteOrgForAdmin(@PathVariable String guid,HttpServletRequest request) throws Exception {
        String key=request.getParameter("key");
        return orgSpaceListService.deleteOrgForAdmin("/organizations-admin/"+guid,HttpMethod.DELETE);
    }

    /**
     * 영역 요약 정보를 조회한다.
     *
     * @param spaceid space id값
     * @return Space 영역 객체
     */
    @GetMapping(V2_URL + "/spaces/{spaceid}/summary")
    public Map<String, Object> getSpaceSummary(@PathVariable String spaceid, HttpServletRequest request) {
        return orgSpaceListService.getSpaceSummary("/spaces/" + spaceid + "/summary-admin", HttpMethod.GET, null);
    }

    /**
     * 영역 쿼터 정보를 조회한다.
     *
     * @param spacequtaid spacequta id
     * @return Map (자바 Map 클래스)
     */
    @GetMapping(V2_URL + "/spaces/{spacequtaid}/quota")
    public Map<String, Object> getSpaceQuota(@PathVariable String spacequtaid, HttpServletRequest request) {
        return orgSpaceListService.getSpaceQuota("/spaces/" + spacequtaid + "/quota-admin", HttpMethod.GET, null);
    }

    /**
     * 특정 영역을 선택하여 영역을 조회한다.
     *
     * @return Map (자바 Map 클래스)
     */
    @GetMapping(V2_URL + "/spaces")
    public Map<String, Object> getSpace(HttpServletRequest request) {
        return orgSpaceListService.getSpace("/spaces-admin", HttpMethod.GET, null);

    }

    /**
     *
     * 운영자 포털에서 조직을 생성한다.
     *
     * @param request
     * @param param
     * @return
     */
    @PostMapping(V2_URL + "/organizations")
    public Map createOrgForAdmin(HttpServletRequest request,@RequestBody Map param){
        return orgSpaceListService.createOrgForAdmin("/organizations",HttpMethod.POST,param);
    }

    /**
     * 운영자 포털에서 Space 을 생성한다.
     *
     * @return CreateOrganizationResponse
     * @throws Exception the exception
     */
    @PostMapping(V2_URL+"/spaces")
    public Map<?,?> createSpaceForAdmin(HttpServletRequest request,@RequestBody Map param){
        String key=request.getParameter("key");
        return orgSpaceListService.createSpaceForAdmin("/spaces",HttpMethod.POST,param);
    }

    /**
     * 공간의 id로 공간에 속한 유저들의 역할을 불러온다.
     *
     * @param spaceid
     * 2021-05-10
     * @return Map (자바 Map 클래스)
     */
    @GetMapping(V2_URL + "/spaces/{spaceid}/user-roles")
    @ResponseBody
    public Map<String, Object> getSpaceRoles(@PathVariable String spaceid, HttpServletRequest request) {
        LOGGER.info(spaceid);
        return commonService.procApiRestTemplate(Constants.V3_URL + "/spaces/" +spaceid+ "/user-roles2", HttpMethod.GET,null, Constants.CF_API, Map.class).getBody();
    }


    /**
     * 조직의 id로 해당 조직에서 유저들이 가진 역할을 조회한다.
     *
     * @param orgId  (org name)
     * 2021-05-12
     * @return Map (자바 Map 클래스)
     */
    @GetMapping(V2_URL + "/orgs/{orgId}/user-roles")
    @ResponseBody
    public Map<String, Object> getSpaceRoles(@PathVariable String orgId, HttpServletRequest request, Object obj) {
        return commonService.procApiRestTemplate(Constants.V2_URL + "/orgs/" +orgId+ "/user-roles", HttpMethod.GET, null, Constants.CF_API, Map.class).getBody();
    }



}
