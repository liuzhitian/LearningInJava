import org.junit.Test;

public class EnumTest {
    @Test
    public void test(){
        Season1 season = Season1.AUTUMN;
        System.out.println(season);

        System.out.println("***********************");
        //返回枚举类所有值的一个数组
        Season1[] values = Season1.values();

        for (Season1 season1: values) {
            System.out.println(season1);
        }

        //返回给定名称的一个枚举类的值,没有就抛异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }

}

interface Info{
    void show();
}
//自定义枚举类
enum Season1 implements Info{


    //枚举类之间对象用逗号隔开，声明方式也变成这样比较简洁的方式
    SPRING("春天","春天到了"){

        @Override
        public String getSeasonName() {
            return super.getSeasonName();
        }

        @Override
        public String getSeasonDesc() {
            return super.getSeasonDesc();
        }

        @Override
        public void show() {
            System.out.println("这是春天");
        };
    },
    SUMMER("夏天","夏天到了"){
        @Override
        public void show() {
            System.out.println("这是夏天");
        };
    },
    AUTUMN("秋天","秋天到了"){
        @Override
        public void show() {
            System.out.println("这是秋天");
        };
    },
    WINTER("冬天","冬天到了"){
        @Override
        public void show() {
            System.out.println("这是冬天");
        };
    };


    public final String seasonName;
    public final String seasonDesc;

    private Season1(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    /**
     * @Description: getSeasonName
     * @Param: []
     * @return: java.lang.String
     * @Author: 刘志天
     * @Date: 2021/2/24
     */
    public String getSeasonName() {
        return seasonName;
    }


    /**
     * @Description: getSeasonDesc
     * @Param: []
     * @return: java.lang.String
     * @Author: 刘志天
     * @Date: 2021/2/24
     */
    public String getSeasonDesc() {
        return seasonDesc;
    }



}
