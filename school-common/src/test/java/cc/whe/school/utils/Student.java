package cc.whe.school.utils;

public class Student {

    private Integer id;
    private String xsbh;
    private String xsxm;
    private Integer sfzx;
    private String zgxlm;
    private String zgxlmc;
    private Double gkzf;
    private String yx;
    private String zy;
    private String nj;
    private String bj;

    @Override
    public String toString() {
        return "id--->"+id+",xsbh---->"+xsbh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getXsbh() {
        return xsbh;
    }

    public void setXsbh(String xsbh) {
        this.xsbh = xsbh;
    }


    public String getXsxm() {
        return xsxm;
    }

    public void setXsxm(String xsxm) {
        this.xsxm = xsxm;
    }


    public Integer getSfzx() {
        return sfzx;
    }

    public void setSfzx(Integer sfzx) {
        this.sfzx = sfzx;
    }


    public String getZgxlm() {
        return zgxlm;
    }

    public void setZgxlm(String zgxlm) {
        this.zgxlm = zgxlm;
    }


    public String getZgxlmc() {
        return zgxlmc;
    }

    public void setZgxlmc(String zgxlmc) {
        this.zgxlmc = zgxlmc;
    }


    public Double getGkzf() {
        return gkzf;
    }

    public void setGkzf(Double gkzf) {
        this.gkzf = gkzf;
    }


    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx;
    }


    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }


    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }


    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

}
