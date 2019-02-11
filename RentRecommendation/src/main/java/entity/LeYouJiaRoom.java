package entity;

public class LeYouJiaRoom extends Room{
    
	private String totalArea;//建筑面积
	private String buildYear;//建成时间
    private LeYouJiaCommunity community;//小区信息
	
    public LeYouJiaCommunity getCommunity() {
        return community;
    }
    public void setCommunity(LeYouJiaCommunity community) {
        this.community = community;
    }
    public String getTotalArea() {
        return totalArea;
    }
    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }
    public String getBuildYear() {
        return buildYear;
    }
    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }
	
	
}
