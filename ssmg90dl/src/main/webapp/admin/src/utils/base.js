const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmg90dl/",
            name: "ssmg90dl",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmg90dl/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "房屋租赁管理系统小程序"
        } 
    }
}
export default base
