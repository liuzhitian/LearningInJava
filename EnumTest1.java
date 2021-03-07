public class EnumTest1 {


}
//自定义枚举类
class Season{
    public final String seasonName;
    public final String seasonDesc;

    private Season(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天","春天到了");
    public static final Season SUMMER = new Season("夏天","夏天到了");
    public static final Season AUTUMN = new Season("秋天","秋天到了");
    public static final Season WINTER = new Season("冬天","冬天到了");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}