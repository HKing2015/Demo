// 分页有几个关键变量:
// 1.当前页 2.当前行 3.每页有多少条数据 4.总数据量 5.总页数 
// 前端需要传来的参数是当前页和每页有多少条数据,剩下的数据可通过数据库查询或者计算得到


// condition用来接收从前端传来的数据,建一个BaseCondition,让其他condition继承,用来分页

public class BaseCondition implements Serializable {
    private Long id;
    //当前页
    private Integer pageIndex;
    //每页有多少条数据
    private Integer pageSize;
    //当前行
    private Integer startRow;
    //总数据量
    private Long totalCount;
    //总页数
    private Integer totalIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //计算起始行
    public Integer getStartRow() {
        int size = 0;
        if (pageIndex == null || pageIndex < 1) {
            pageIndex = 1;
        }
        if (pageSize == null) {
            size = 10;
        } else {
            size = pageSize;
        }
        return (pageIndex - 1) * size;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    //计算总页数
    public Integer getTotalIndex() {
        if(pageSize >= totalCount) {
            return 1;
        }
        if(totalCount%pageSize == 0) {
            return (int)(totalCount/pageSize);
        } else {
            return (int)(totalCount/pageSize + 1);
        }
    }

    public void setTotalIndex(Integer totalIndex) {
        this.totalIndex = totalIndex;
    }
}



//前端ajax请求
//totalIndex是全局变量,ajax请求的时候返回,用来判断能不能点击下一页
function showList(pageIndex) {
    $.ajax({
        type: "post",
        url: "/ip/getIpList",
        data: {
            "pageIndex": pageIndex,
            "pageSize": $("#pageSize").val()
        },
        dataType: "json",
        async: false,
        success: function (data) {
            totalIndex = data.totalIndex;
            //处理数据
        },
        error: function () {
            console.log("出现异常...");
        }
    });
}

//下一页
function nextPage() {
    var $pageIndex = $("#pageIndex").val();
    //如果请求页大于总页数,不再请求
    if(totalIndex <= parseInt($pageIndex)) {
        return;
    }

    if($pageIndex == "" || $pageIndex == null) {
        $pageIndex = 1;
    }
    $("#pageIndex").val(parseInt($pageIndex) + 1);
    showList($("#pageIndex").val());
}

//上一页
function previousPage() {
    var $pageIndex = $("#pageIndex").val();
    if($pageIndex <= 1) {
        return;
    }

    if($pageIndex == "" || $pageIndex == null) {
        $pageIndex = 1;
    }
    $("#pageIndex").val(parseInt($pageIndex) - 1);
    showList($("#pageIndex").val());
}


//在html中新增两个隐藏元素记录当前页数和默认的每页有多少条数据
<input id="pageIndex" name="pageIndex" class="hide" value="1" />
<input id="pageSize" name="pageSize" class="hide" value="10" />




查询
   @ResponseBody
    @RequestMapping("/getIpList")
    public Map<?,?> getIpList(IpinfoCondition condition) {
        Map<String, Object> data = new HashMap<>();

        // 查询总行数
        Long totalCount = ipinfoService.selectCount(condition);
        condition.setTotalCount(totalCount);

        if (totalCount > 0 && condition.getStartRow() < totalCount) {
            List<Ipinfo> list = ipinfoService.ipSearch(condition);

            data.put("resultList", list);
            data.put("totalIndex", condition.getTotalIndex());
        }
        return data;
    }

//sql中limit#{startRow},#{pageSize}就可以了




