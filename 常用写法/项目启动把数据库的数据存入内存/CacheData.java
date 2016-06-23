//1.写一个静态的变量map或者list,用来存储数据库的数据.

public class CacheData {
    public static Map<Integer, List<Ipinfo>> cacheMap = new HashMap<Integer, List<Ipinfo>>();
}


/**
 *2.关键在要执行的方法上使用@PostConstruct注解,在项目启动容器加载类的时候执行该方法.
 *不要忘记加上component注解,不然容器找不到该类.
 */

@Component
public class ResourceInit {

    @Autowired
    private IpinfoMapper ipinfoMapper;

    @PostConstruct
    public void init() {

        List<Ipinfo> iplist = ipinfoMapper.selectAll();

        CacheData.cacheMap = map;
    }
}
