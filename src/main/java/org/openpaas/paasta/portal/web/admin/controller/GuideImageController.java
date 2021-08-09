package org.openpaas.paasta.portal.web.admin.controller;


import org.openpaas.paasta.portal.web.admin.common.Common;
import org.openpaas.paasta.portal.web.admin.model.GuideImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class GuideImageController extends Common {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainController.class);
    private final String V2_URL = "/v2";

    @RequestMapping(value = {"/guideImage"}, method = RequestMethod.GET)
    public ModelAndView getGuideImageMain() {
        return new ModelAndView() {{
            setViewName("/guideImage/guideImage");
        }};
    }

    @GetMapping(V2_URL + "/guide_images")
    @ResponseBody
    public Map<?,?> getGuideImages(){
        LOGGER.info("getGuideImages");
        return guideImageService.curlAPI(V2_URL + "/guide_images", HttpMethod.GET, null);
    }

    @GetMapping(V2_URL + "/guide_images/{no:.+}")
    @ResponseBody
    public Map<?,?> getGuideImage(@PathVariable int no){
        LOGGER.info("getGuideImage : " + no );
        return guideImageService.curlAPI(V2_URL + "/guide_images/" + no, HttpMethod.GET, null);
    }

    @PostMapping(V2_URL + "/guide_images")
    @ResponseBody
    public Map<?,?> createGuideImage(@RequestBody GuideImage guideImage){
        LOGGER.info("createGuideImage : " + guideImage.toString());
        return guideImageService.curlAPI(V2_URL + "/guide_images", HttpMethod.POST, guideImage);
    }

    @PutMapping(V2_URL + "/guide_images")
    @ResponseBody
    public Map<?,?> updateGuideImage(@RequestBody GuideImage guideImage ){
        LOGGER.info("updateGuideImage : " + guideImage.toString());
        return guideImageService.curlAPI(V2_URL + "/guide_images" , HttpMethod.PUT, guideImage);
    }

    @DeleteMapping(V2_URL + "/guide_images/{no:.+}")
    @ResponseBody
    public Map<?,?> deleteGuideImage(@PathVariable int no){
        LOGGER.info("deleteGuideImage : " + no );
        return guideImageService.curlAPI(V2_URL + "/guide_images/" + no, HttpMethod.DELETE, null);
    }
}
