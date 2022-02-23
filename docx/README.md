# Java桌面宠物------小白

> [Gitee代码](https://gitee.com/xymtop/xiaobai)

> [安装包下载](https://download.xymtop.com/src/front/share.php?id=666666)

## 介绍

> 一个安安静静陪伴你的好朋友

## 使用手册

1. 去上面下载地址下载安装包到电脑
2. 解压压缩文件（小白.7z）
3. 打开文件夹，目录结构如下

```bash



├─recycle      投喂小白的东西都保存在这哦
└─res          资源文件
    ├─msg      消息音频存放地址
    │  └─lib   内置消息音频存放地址
    ├─pet       小白的形象存放
    │  ├─0      小白的第0号形象
    │  │  ├─a    小白的第1个完整动作
    │  │  ├─b   小白的第2个完整动作
    │  │  ├─c   小白的第3个完整动作
    │  │  ├─d   小白的第4个完整动作
    │  │  └─e   小白的第5个完整动作
    │  └─1      小白的第0号形象
    │      ├─a
    │      ├─b
    │      ├─c
    │      ├─d
    │      └─e
    ├─pymusic    声音配置文件
    │  ├─Include
    │  ├─lib2to3
    │  │  └─tests
    │  │      └─data
    │  ├─tcl
    │  │  ├─encoding
    │  │  ├─http1.0
    │  │  ├─msgs
    │  │  ├─opt0.4
    │  │  └─tzdata
    │  │      ├─Africa
    │  │      ├─America
    │  │      │  ├─Argentina
    │  │      │  ├─Indiana
    │  │      │  ├─Kentucky
    │  │      │  └─North_Dakota
    │  │      ├─Antarctica
    │  │      ├─Arctic
    │  │      ├─Asia
    │  │      ├─Atlantic
    │  │      ├─Australia
    │  │      ├─Brazil
    │  │      ├─Canada
    │  │      ├─Chile
    │  │      ├─Etc
    │  │      ├─Europe
    │  │      ├─Indian
    │  │      ├─Mexico
    │  │      ├─Pacific
    │  │      ├─SystemV
    │  │      └─US
    │  └─tk
    │      ├─images
    │      ├─msgs
    │      └─ttk
    ├─static   静态资源文件
    └─wall     静态壁纸文件
    xiaobai.exe  运行入口文件，双击即可运行，多次双击会多开小白

```

点击xiaobai.exe即可运行

## 运行时状态说明

点击运行后，右下角出现透明托盘，用户不要以为没有托盘哦

> 将鼠标轻轻移动到托盘上，会显示小白的运行状态

![](.\static\Snipaste_2022-02-23_21-46-54.png)

> 运行状态解读

```sh
状态 >  小白的运行状态，是否运行
程序标识 > 主程序或者是小白n号，取决于您多开的小白的数量
当前人物编号 >取决于您 res/pet 下小白形象目录的编号，编号必须由小到大，不能逾越
当前窗口显示状态 >当前小白是否在您的桌面上玩耍，当然，小白也会困的，困了就不理你了，也就不显示了
本次运行时长 >从小白开始运行开始到现在的时间
本次投喂n个文件 >小白也会饿哦，你需要投喂给他文件吃呢。注意：他不能吃文件夹哦
```

> 运行效果

![](.\static\Snipaste_2022-02-23_21-47-34.png)

```sh
注意:小白运行动作是随机切换的
```

> 右键菜单选项
>
> 当您在人物上点击右键菜单后会弹出右键菜单哦

![](.\static\Snipaste_2022-02-23_21-47-50.png)

![](.\static\Snipaste_2022-02-23_21-49-28.png)

> 右键菜单解读

```sh
第一句 > 标识该小白是不是主程序
切换人物 > 可以切换小白的形象
和我聊天 > 可以和小白或者开发者进行聊天哦
更换专属壁纸 > 可以更换您的壁纸（内置20张高清壁纸，大部分为IU的壁纸，别问我为什么，问就是IU好看）
帮助 > 跳转到帮助文档
关于 >打开程序开源地址
隐藏 >将小白隐藏到托盘（注意:请不要隐藏主程序外的小白，因为这些小白自我显现的时间较长，怕您等不起）
多开 > 复制一个小白
退出 > 如果是主程序就关闭整个程序，否则只关闭这一只小白
```

![](.\static\Snipaste_2022-02-23_21-48-10.png)

> 聊天页面

![](.\static\Snipaste_2022-02-23_22-30-16.png)

> 托盘菜单解读

```sh
退出 > 退出程序
投喂站 > 打开投喂的文件存放的文件夹
```



## 其他技巧

### 用户自己添加角色

```sh
1. 打开  res/pet
2. 根据内置的文件夹新建相同的目录结构
3.目录结构命名方法，数字命名，从小到大，比如内置为0，1两目录，用户可以新建2，3,4,5....目录
4.新建目录后，角色存放应有5中动作，分别为abcde，请将各种动作文件分别放在对应文件夹中
5.此外应该注意：动作文件命名应该为 父文件夹(数字).png  
```

### 投喂小白

```sh
投喂小白非常简单，直接将文件拖给小白就可以啦
```

![](.\static\Snipaste_2022-02-23_22-33-05.png)



## 二次开发

### 源码结构

```bash

├─build
│  └─res    资源文件
│      ├─clickOne  人物动作资源  
│      ├─clickTwo  人物动作资源  
│      ├─default   人物动作资源  
│      ├─grabed    人物动作资源  
│      ├─pymusic   Python外接音频播放接口
│      ├─static    软件静态资源文件
│      └─walking   人物动作资源
├─docx             文档
│  └─static        文档静态资源
├─image  
│  └─README
└─mypet            代码文件
    ├─bin
    │  └─com
    │      └─xymtop
    │          └─res
    │              ├─clickOne  人物动作资源
    │              ├─clickTwo  人物动作资源
    │              ├─default   人物动作资源
    │              ├─grabed    人物动作资源
    │              ├─msg       人物消息音频储存
    │              ├─pymusic    Python外接播放接口
    │              │  ├─Include
    │              │  ├─lib2to3
    │              │  │  └─tests
    │              │  │      └─data
    │              │  ├─tcl
    │              │  │  ├─encoding
    │              │  │  ├─http1.0
    │              │  │  ├─msgs
    │              │  │  ├─opt0.4
    │              │  │  └─tzdata
    │              │  │      ├─Africa
    │              │  │      ├─America
    │              │  │      │  ├─Argentina
    │              │  │      │  ├─Indiana
    │              │  │      │  ├─Kentucky
    │              │  │      │  └─North_Dakota
    │              │  │      ├─Antarctica
    │              │  │      ├─Arctic
    │              │  │      ├─Asia
    │              │  │      ├─Atlantic
    │              │  │      ├─Australia
    │              │  │      ├─Brazil
    │              │  │      ├─Canada
    │              │  │      ├─Chile
    │              │  │      ├─Etc
    │              │  │      ├─Europe
    │              │  │      ├─Indian
    │              │  │      ├─Mexico
    │              │  │      ├─Pacific
    │              │  │      ├─SystemV
    │              │  │      └─US
    │              │  └─tk
    │              │      ├─images
    │              │      ├─msgs
    │              │      └─ttk
    │              ├─static
    │              ├─util  外部外接脚本
    │              ├─walking  人物动作资源
    │              └─wall     内置壁纸资源
    ├─lib
    ├─src
    │  └─com
    │      └─xymtop
    │          └─res
    │              ├─clickOne
    │              ├─clickTwo
    │              ├─default
    │              ├─grabed
    │              ├─msg
    │              ├─pymusic
    │              │  ├─Include
    │              │  ├─lib2to3
    │              │  │  └─tests
    │              │  │      └─data
    │              │  ├─tcl
    │              │  │  ├─encoding
    │              │  │  ├─http1.0
    │              │  │  ├─msgs
    │              │  │  ├─opt0.4
    │              │  │  └─tzdata
    │              │  │      ├─Africa
    │              │  │      ├─America
    │              │  │      │  ├─Argentina
    │              │  │      │  ├─Indiana
    │              │  │      │  ├─Kentucky
    │              │  │      │  └─North_Dakota
    │              │  │      ├─Antarctica
    │              │  │      ├─Arctic
    │              │  │      ├─Asia
    │              │  │      ├─Atlantic
    │              │  │      ├─Australia
    │              │  │      ├─Brazil
    │              │  │      ├─Canada
    │              │  │      ├─Chile
    │              │  │      ├─Etc
    │              │  │      ├─Europe
    │              │  │      ├─Indian
    │              │  │      ├─Mexico
    │              │  │      ├─Pacific
    │              │  │      ├─SystemV
    │              │  │      └─US
    │              │  └─tk
    │              │      ├─images
    │              │      ├─msgs
    │              │      └─ttk
    │              ├─static
    │              ├─util
    │              ├─walking
    │              └─wall
    └─static
```

### 源码内部结构

```sh
Command 控制台命令执行
Email   邮件
Main    主入口
Mp3ToWav 转换mp3
Msgui  
Music   音乐播放
MyFile  文件相关操作
MyHttp  网络http相关
MyKey   键盘操作
MyWindow 系统窗口相关
Pass   加密相关
Pet    桌面宠物代码
WallPaper 壁纸相关
```

### 相关脚本使用

```bash
music.exe  
直接传参音频地址即可
eg:music  ./music.mp3
```

## 使用到的资料

> 木小果api

```sh
反馈邮件发送接口
https://api.muxiaoguo.cn/api/mail
毒鸡汤
https://api.muxiaoguo.cn/api/dujitang
```

> 小白api

```sh
控制数据获取，包括小白问候等
https://xiaobai.xymtop.com/api/
```

>  网易语音合成接口

```sh
小白语音合成	
http://tts.youdao.com/fanyivoice?word=word&le=zh&keyfrom=speaker-target
```

