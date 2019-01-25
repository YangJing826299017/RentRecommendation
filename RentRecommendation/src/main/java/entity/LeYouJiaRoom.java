package entity;

public class LeYouJiaRoom {
	
	private String picturePath;
	private String roomName;//房间名字
	private String roomType;//户型N室N房
	private String totalArea;//建筑面积
	private String realArea;//房间实际面积
	private String decorationDegree;//装修程度
	private String height;//楼高
	private String buildYear;//建成时间
	private String address;//地址
	private String description;//描述,以逗号间隔
	
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}
	public String getRealArea() {
		return realArea;
	}
	public void setRealArea(String realArea) {
		this.realArea = realArea;
	}
	public String getDecorationDegree() {
		return decorationDegree;
	}
	public void setDecorationDegree(String decorationDegree) {
		this.decorationDegree = decorationDegree;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "LeYouJiaRoom [picturePath=" + picturePath + ", roomName=" + roomName + ", roomType=" + roomType
				+ ", totalArea=" + totalArea + ", realArea=" + realArea + ", decorationDegree=" + decorationDegree
				+ ", height=" + height + ", buildYear=" + buildYear + ", address=" + address + ", description="
				+ description + "]";
	}
	
	
}
