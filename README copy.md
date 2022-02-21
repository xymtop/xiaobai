# Java桌面宠物------小白

> [Gitee代码](https://gitee.com/xymtop/xiaobai)

> [安装包下载](https://gitee.com/xymtop/xiaobai/releases/v1.0)

## 介绍

>  一个安安静静陪伴你的好朋友



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

