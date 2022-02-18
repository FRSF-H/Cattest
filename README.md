#  Cattest

#### 介绍
大一期间Java的课程设计，项目编写24天，实现简单的车牌定位以及字符分割，因目前技术、时间有限，没能实现文字识别，
仅在有限知识内保存字模信息。


#### 软件架构
普通Java程序


#### 使用说明
1. 打开该页面的 **carpic目录** 选择 **jpg** 格式的车牌图片上传，carpic下有一张实例图片，处理后的图像位于子目录下
2. 目录不能有 **中文**
3. 学习开发，适用于简单处理
4. 项目使用swing设计界面，辅助设计工具为 **JFormDesigner**, 为IDEA插件， 需要插件项目才能正常运行
5. 项目程序入口有两个，login内运行的带登录界面，需配置同目录下mysql类；judge下启动不带主界面，直接进入项目主页面，
下面为主页面启动界面
6. 编译使用 **jdk11**

#### 部分使用过程图片
1. 灰度化
<img src="https://gitee.com/frsf/Cattest/raw/master/md_img/dark.png">
2. sobel
<img src="https://gitee.com/frsf/Cattest/raw/master/md_img/sobel.png">
3. 闭运算
<img src="https://gitee.com/frsf/Cattest/raw/master/md_img/close.png">
4.结果
<img src="https://gitee.com/frsf/Cattest/raw/master/md_img/img.png">

