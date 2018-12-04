package prictice;

public enum InsuranceType {
    TRAIN_DELAY(0,"火车票延误险"),
    HOTEL_CANCEL(1,"酒店取消险"),
    MENPIAO_ACCIDENT(2,"门票意外险"),
    BUS_GIVEN(3,"汽车票赠险"),

    DOMESTIC_FLIGHT_DELAY(4, "国内延误险"),
    DOMESTIC_FLIGHT_ACCIDENT(5,"国内航意险"),

    INTER_FLIGHT_DELAY(6,"国际延误险"),
    INTER_FLIGHT_ACCIDENT(7,"国际航意险"),
    INTER_TRAVEL(8,"境外旅行险"),
    HOTEL_ACCIDENT(9,"酒店意外险"),
    BUS_ACCIDENT(10, "汽车票意外险"),
    TRAIN_ACCIDENT(11, "火车票意外险"),
    HOTEL_PREGNANT(12, "酒店怀孕险"),

    IMALL_NO_TYING(13,"保险商城非搭售"),
    ACCOUNT_SECURITY(14,"账户安全险"),
    ACCOUNT_SECURITY_GIVEN(15,"账户安全险赠险"),
    INTER_STANDARD_TRAVEL(16,"国际旅行险"),
    TRAIN_TUIPIAO(17,"火车票退票险"),
    DOMESTIC_FLIGHT_COMBINE(18,"组合险"),
    YEAR_ACCIDENT(19,"全年航意险"),
    SINGLE_FLIGHT_TRAVEL(20,"单程旅行险"),
    HOLIDAY_TRAVEL(21, "旅行险"),
    FLIGHT_TUIPIAO(22,"机票退票险"),

    NONE(-99,"none");

    private Integer code;
    private String desc;

    private InsuranceType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static InsuranceType fromName(String name){
        for(InsuranceType e : InsuranceType.values()){
            if (e.name().equalsIgnoreCase(name)){
                return e;
            }
        }
        return InsuranceType.NONE;
    }

    @Deprecated
    public static InsuranceType fromDesc(String desc){
        for(InsuranceType e : InsuranceType.values()){
            if (e.getDesc().equalsIgnoreCase(desc)){
                return e;
            }
        }
        return InsuranceType.NONE;
    }

    public static InsuranceType fromCode(Integer code){
        for(InsuranceType e : InsuranceType.values()){
            if (e.getCode() == code){
                return e;
            }
        }
        return InsuranceType.NONE;
    }

    public static void main(String[] args) {

    }
}
