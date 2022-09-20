
package Dtolist; 

public class Dto {
	private String Mgnumber; // 관리번호
	private String X_coordinate; //x좌표
	private String Y_coordinate; //y좌표
	private String Distance; //거리
	private String District; //자치구
	private String Wifi_name; //와이파이명
	private String Road_Address; //도로명주소
	private String Detail_Address; //상세주소
	private String Install_location; //설치위치
	private String Install_Type; //설치유형
	private String Install_Agency;//설치기관
	private String Service_Class; //서비스구분
	private String Kind_Net; //망종류
	private String Install_Year; //설치년도
	private String In_Out; //실내외구분
	private String Wifi_connect; //wifi접속환경
	private String Operation_Date; // 작업일자
	
	public Dto(String Mgnumber, String X_coordinate, String Y_coordinate, String Distance, String District,
			String Wifi_name, String Road_Address, String Detail_Address, String Install_location, String Install_Type,
			String Install_Agency, String Service_Class, String Kind_Net, String Install_Year, String In_Out, String Wifi_connect,
			String Operation_Date) {
		
		this.Mgnumber = Mgnumber;
		this.X_coordinate = X_coordinate;
		this.Y_coordinate = Y_coordinate;
        this.Distance = Distance;
        this.District = District;
        this.Wifi_name = Wifi_name;
        this.Road_Address = Road_Address;
        this.Detail_Address = Detail_Address;
        this.Install_location = Install_location;
        this.Install_Type = Install_Type;
        this.Install_Agency = Install_Agency;
        this.Service_Class = Service_Class;
        this.Kind_Net = Kind_Net;
        this.Install_Year = Install_Year;
        this.In_Out = In_Out;
        this.Wifi_connect = Wifi_connect;
        this.Operation_Date = Operation_Date;
		
	}





	public Dto() {
		
	}



	//getter, setter
	public String getMgnumber() {
		return Mgnumber;
	}
	public void setMgnumber(String mgnumber) {
		Mgnumber = mgnumber;
	}
	public String getX_coordinate() {
		return X_coordinate;
	}
	public void setX_coordinate(String x_coordinate) {
		X_coordinate = x_coordinate;
	}
	public String getY_coordinate() {
		return Y_coordinate;
	}
	public void setY_coordinate(String y_coordinate) {
		Y_coordinate = y_coordinate;
	}
	public String getDistance() {
		return Distance;
	}
	public void setDistance(String distance) {
		Distance = distance;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getWifi_name() {
		return Wifi_name;
	}
	public void setWifi_name(String wifi_name) {
		Wifi_name = wifi_name;
	}
	public String getRoad_Address() {
		return Road_Address;
	}
	public void setRoad_Address(String road_Address) {
		Road_Address = road_Address;
	}
	public String getDetail_Address() {
		return Detail_Address;
	}
	public void setDetail_Address(String detail_Address) {
		Detail_Address = detail_Address;
	}
	public String getInstall_location() {
		return Install_location;
	}
	public void setInstall_location(String install_location) {
		Install_location = install_location;
	}
	public String getInstall_Type() {
		return Install_Type;
	}
	public void setInstall_Type(String install_Type) {
		Install_Type = install_Type;
	}
	public String getInstall_Agency() {
		return Install_Agency;
	}
	public void setInstall_Agency(String install_Agency) {
		Install_Agency = install_Agency;
	}
	public String getService_Class() {
		return Service_Class;
	}
	public void setService_Class(String service_Class) {
		Service_Class = service_Class;
	}
	public String getKind_Net() {
		return Kind_Net;
	}
	public void setKind_Net(String kind_Net) {
		Kind_Net = kind_Net;
	}
	public String getInstall_Year() {
		return Install_Year;
	}
	public void setInstall_Year(String install_Year) {
		Install_Year = install_Year;
	}
	public String getIn_Out() {
		return In_Out;
	}
	public void setIn_Out(String in_Out) {
		In_Out = in_Out;
	}
	public String getWifi_connect() {
		return Wifi_connect;
	}
	public void setWifi_connect(String wifi_connect) {
		Wifi_connect = wifi_connect;
	}
	public String getOperation_Date() {
		return Operation_Date;
	}
	public void setOperation_Date(String operation_Date) {
		Operation_Date = operation_Date;
	}
}
