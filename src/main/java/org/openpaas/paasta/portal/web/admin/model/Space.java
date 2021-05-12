package org.openpaas.paasta.portal.web.admin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 공간 모델
 *
 * @author 조민구
 * @version 1.0
 * @since 2016.5.30 최초작성
 */
public class Space {
    private String orgName;
    private String spaceName;
    private String newSpaceName;
    private String orgGuid;
    private String spaceQuotaGuid;

    private UUID guid;
    private String name;

    private Integer serviceCount = 0;

    private Integer appCount = 0;

    private Integer appCountStarted = 0;
    private Integer appCountStopped = 0;
    private Integer appCountCrashed = 0;

    private Integer memDevTotal;

    private Integer memProdTotal;

    private Integer memoryUsage;
    private Integer memoryLimit;

    private List<App> apps = new ArrayList<App>();

    private List<Service> services = new ArrayList<Service>();

    public Space(String orgName, String spaceName, String newSpaceName, String orgGuid, String spaceQuotaGuid, UUID guid, String name, Integer serviceCount, Integer appCount, Integer appCountStarted, Integer appCountStopped, Integer appCountCrashed, Integer memDevTotal, Integer memProdTotal, Integer memoryUsage, Integer memoryLimit, List<App> apps, List<Service> services) {
        this.orgName = orgName;
        this.spaceName = spaceName;
        this.newSpaceName = newSpaceName;
        this.orgGuid = orgGuid;
        this.spaceQuotaGuid = spaceQuotaGuid;
        this.guid = guid;
        this.name = name;
        this.serviceCount = serviceCount;
        this.appCount = appCount;
        this.appCountStarted = appCountStarted;
        this.appCountStopped = appCountStopped;
        this.appCountCrashed = appCountCrashed;
        this.memDevTotal = memDevTotal;
        this.memProdTotal = memProdTotal;
        this.memoryUsage = memoryUsage;
        this.memoryLimit = memoryLimit;
        this.apps = apps;
        this.services = services;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getNewSpaceName() {
        return newSpaceName;
    }

    public void setNewSpaceName(String newSpaceName) {
        this.newSpaceName = newSpaceName;
    }

    public String getOrgGuid() {
        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    public String getSpaceQuotaGuid() {
        return spaceQuotaGuid;
    }

    public void setSpaceQuotaGuid(String spaceQuotaGuid) {
        this.spaceQuotaGuid = spaceQuotaGuid;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(Integer serviceCount) {
        this.serviceCount = serviceCount;
    }

    public Integer getAppCount() {
        return appCount;
    }

    public void setAppCount(Integer appCount) {
        this.appCount = appCount;
    }

    public Integer getAppCountStarted() {
        return appCountStarted;
    }

    public void setAppCountStarted(Integer appCountStarted) {
        this.appCountStarted = appCountStarted;
    }

    public Integer getAppCountStopped() {
        return appCountStopped;
    }

    public void setAppCountStopped(Integer appCountStopped) {
        this.appCountStopped = appCountStopped;
    }

    public Integer getAppCountCrashed() {
        return appCountCrashed;
    }

    public void setAppCountCrashed(Integer appCountCrashed) {
        this.appCountCrashed = appCountCrashed;
    }

    public Integer getMemDevTotal() {
        return memDevTotal;
    }

    public void setMemDevTotal(Integer memDevTotal) {
        this.memDevTotal = memDevTotal;
    }

    public Integer getMemProdTotal() {
        return memProdTotal;
    }

    public void setMemProdTotal(Integer memProdTotal) {
        this.memProdTotal = memProdTotal;
    }

    public Integer getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Integer memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Space{" +
                "orgName='" + orgName + '\'' +
                ", spaceName='" + spaceName + '\'' +
                ", newSpaceName='" + newSpaceName + '\'' +
                ", orgGuid='" + orgGuid + '\'' +
                ", spaceQuotaGuid='" + spaceQuotaGuid + '\'' +
                ", guid=" + guid +
                ", name='" + name + '\'' +
                ", serviceCount=" + serviceCount +
                ", appCount=" + appCount +
                ", appCountStarted=" + appCountStarted +
                ", appCountStopped=" + appCountStopped +
                ", appCountCrashed=" + appCountCrashed +
                ", memDevTotal=" + memDevTotal +
                ", memProdTotal=" + memProdTotal +
                ", memoryUsage=" + memoryUsage +
                ", memoryLimit=" + memoryLimit +
                ", apps=" + apps +
                ", services=" + services +
                '}';
    }
}
