package org.openpaas.paasta.portal.web.admin.service;

import org.openpaas.paasta.portal.web.admin.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GuideImageService {

    final
    CommonService commonService;

    public GuideImageService(CommonService commonService) {
        this.commonService = commonService;
    }

    public Map<?, ?> curlAPI(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(reqUrl, httpMethod, obj, Constants.COMMON_API, Map.class).getBody();
    }

    public Map<?, ?> curlStorageAPI(String reqUrl, HttpMethod httpMethod, Object obj) {
        return commonService.procApiRestTemplate(reqUrl, httpMethod, obj, Constants.STORAGE_API, Map.class).getBody();
    }
}
