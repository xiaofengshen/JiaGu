#### 使用方法



##### 1、在项目的根build.gradle添加

###### 		maven { url 'https://dl.bintray.com/awsyc123/JiaGu' }

######  		classpath "com.yc:jiaGu:1.0.0"



##### 2、在应用程序的build.gradle 添加

######   	 apply plugin: 'com.yc.jiagu'

​    `jiagu {`

    username "360用户名"
    userpwd "360密码"
    keyStorePath(file('..\\app\\cold_wallet.jks').absolutePath)
    //    签领 密码
    keyStorePwd "签名密码"
    //    签领 别名
    keyStoreAlias "签名别名"
    //    别名密码
    keyStoreAliasPwd "签名别名密码"
`// 加固工具 路径`
    `jiaguToolsPath "C:\\Users\\Administrator\\Desktop\\360jiagubao_windows_64\\jiagu\\jiagu.jar"`

`}`









```




    
     
  
     
     

```