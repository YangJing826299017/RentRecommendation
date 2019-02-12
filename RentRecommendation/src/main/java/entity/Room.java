package entity;

import java.util.List;
import java.util.Map;

public class Room {
    
	/**基本信息*/
    private String roomUrl;
    private String roomName;//房间名字
    private String rentMoney;//租金
    private String unit;//租金单位
    private List<String> rentWays;//租借方式 [整租/押二付款一]
    private String houseOrientation;//房屋朝向
    private String housingAllocation;//房屋配置 
    private String housingSourceCharacteristics;//房源特色
    private Map<String,String> busStation;//公交站
    private Map<String,String> subwayStation;//地铁站
    private String roomType;//户型N室N房
    private String decorationDegree;//装修程度
    private String realArea;//房间实际面积
    private String height;//楼高
    private String address;//地址
    private String totalArea;//建筑面积
	private String roomBuildYear;//建成时间
    
    /**小区信息*/
    private String communityName;//小区名字
    private String communityBuildYear;//建造年代
    private String communityLiveNumber;//规划户数
    private String communityBuildArea;//建筑面积
    private String communityPlotRatio;//容积率
    private String communityNumberOfParkingSpaces;//车位个数
    private String communityAfforestationRate;//绿化率
    private String communityPropertyCompany;//物业公司

    
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getDecorationDegree() {
        return decorationDegree;
    }
    public void setDecorationDegree(String decorationDegree) {
        this.decorationDegree = decorationDegree;
    }
    public String getRealArea() {
        return realArea;
    }
    public void setRealArea(String realArea) {
        this.realArea = realArea;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public List<String> getRentWays() {
        return rentWays;
    }
    public void setRentWays(List<String> rentWays) {
        this.rentWays = rentWays;
    }
    public String getHouseOrientation() {
        return houseOrientation;
    }
    public void setHouseOrientation(String houseOrientation) {
        this.houseOrientation = houseOrientation;
    }
    public String getHousingAllocation() {
        return housingAllocation;
    }
    public void setHousingAllocation(String housingAllocation) {
        this.housingAllocation = housingAllocation;
    }
    public String getHousingSourceCharacteristics() {
        return housingSourceCharacteristics;
    }
    public void setHousingSourceCharacteristics(String housingSourceCharacteristics) {
        this.housingSourceCharacteristics = housingSourceCharacteristics;
    }
    public Map<String, String> getBusStation() {
        return busStation;
    }
    public void setBusStation(Map<String, String> busStation) {
        this.busStation = busStation;
    }
    public Map<String, String> getSubwayStation() {
        return subwayStation;
    }
    public void setSubwayStation(Map<String, String> subwayStation) {
        this.subwayStation = subwayStation;
    }
    public String getRentMoney() {
        return rentMoney;
    }
    public void setRentMoney(String rentMoney) {
        this.rentMoney = rentMoney;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}
	public String getCommunityBuildYear() {
		return communityBuildYear;
	}
	public void setCommunityBuildYear(String communityBuildYear) {
		this.communityBuildYear = communityBuildYear;
	}
	public String getCommunityLiveNumber() {
		return communityLiveNumber;
	}
	public void setCommunityLiveNumber(String communityLiveNumber) {
		this.communityLiveNumber = communityLiveNumber;
	}
	public String getCommunityBuildArea() {
		return communityBuildArea;
	}
	public void setCommunityBuildArea(String communityBuildArea) {
		this.communityBuildArea = communityBuildArea;
	}
	public String getCommunityPlotRatio() {
		return communityPlotRatio;
	}
	public void setCommunityPlotRatio(String communityPlotRatio) {
		this.communityPlotRatio = communityPlotRatio;
	}
	public String getCommunityNumberOfParkingSpaces() {
		return communityNumberOfParkingSpaces;
	}
	public void setCommunityNumberOfParkingSpaces(String communityNumberOfParkingSpaces) {
		this.communityNumberOfParkingSpaces = communityNumberOfParkingSpaces;
	}
	public String getCommunityAfforestationRate() {
		return communityAfforestationRate;
	}
	public void setCommunityAfforestationRate(String communityAfforestationRate) {
		this.communityAfforestationRate = communityAfforestationRate;
	}
	public String getCommunityPropertyCompany() {
		return communityPropertyCompany;
	}
	public void setCommunityPropertyCompany(String communityPropertyCompany) {
		this.communityPropertyCompany = communityPropertyCompany;
	}
	public String getRoomBuildYear() {
		return roomBuildYear;
	}
	public void setRoomBuildYear(String roomBuildYear) {
		this.roomBuildYear = roomBuildYear;
	}
    
}
