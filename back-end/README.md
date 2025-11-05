# 大事件 *(黑马程序员 Spring Boot3 + Vue3 视频教程配套项目)*

##### 课程链接: https://www.bilibili.com/video/BV14z4y1N7pg

### 本人在项目开发过程中产生的错误

> 1. **Service实现类** (impl) 没有添加 @Service注解
> 2. 实现**JWT**认证与**拦截器**后没有将后端**测试接口**路径和打开knif4j提供的**接口文档**路径设置为**不拦截** (*参考: https://blog.csdn.net/2202_75540275/article/details/148169580?ops_request_misc=%257B%2522request%255Fid%2522%253A%252243cb590884b412806c70d3cf55f28295%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=43cb590884b412806c70d3cf55f28295&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-1-148169580-null-null.142^v102^pc_search_result_base7&utm_term=knif4j请求文档异常】&spm=1018.2226.3001.4187*)
> 3. 测试接口时，要求传入**表单格式**数据但是传入**JSON格式**数据

### 课程中出现的错误

> 1. 按照课程进行依赖配置会导致无法成功启动项目，Spring Boot版本设置为 **3.1.5**，其他依赖的版本也要修改以适配此版本 (*参考: https://github.com/BaichuanTang/BigEvent/blob/main/big-event-backend/pom.xml*)
