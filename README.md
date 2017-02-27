# MyOSChina
学习开源中国

###全局类分析
- BaseApplication 封装有SharedPreferences数据储存对象,以及吐司对象
- SimplexToast 将一个吐司单例化，并且作防止频繁点击的处理,最后吐司创建过程中貌似没有实现这种效果
- AppContext 全局应用程序类用于保存和调用全局应用配置及访问网络数据
    * AppConfig 应用程序配置类用于保存用户相关信息及设置
### 流程上的分析

-