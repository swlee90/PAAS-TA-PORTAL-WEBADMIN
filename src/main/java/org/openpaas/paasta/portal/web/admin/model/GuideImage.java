package org.openpaas.paasta.portal.web.admin.model;



public class GuideImage {
    String name;
    String gubun;
    String gubun2;
    String url;
    int id;

    public GuideImage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getGubun2() {
        return gubun2;
    }

    public void setGubun2(String gubun2) {
        this.gubun2 = gubun2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GuideImage{" +
                "name='" + name + '\'' +
                ", gubun='" + gubun + '\'' +
                ", gubun2='" + gubun2 + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                '}';
    }
}
