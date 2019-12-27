# VScode C++使用安装使用
安装就不多做赘述了，主要参考了官方文档里的[链接](https://code.visualstudio.com/docs/cpp/config-clang-mac),其中也遇到了些问题如mac下无法断点调试的问题。
## C++环境
需要安装的插件如下

- [C++ extension for VS Code](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools) c++的官方插件
- [vscode-lldb](https://github.com/vadimcn/vscode-lldb)mac下面不能用lldb调试需要下载这个插件解决

   具体问题如下链接所示。
- [知乎问题](https://zhuanlan.zhihu.com/p/94047126)
- https://link.zhihu.com/?target=https%3A//github.com/microsoft/vscode-cpptools/issues/3829
-https://link.zhihu.com/?target=https%3A//stackoverflow.com/questions/58329611/vscode-macos-catalina-doesnt-stop-on-breakpoints-on-c-c-debug
### 安装插件
### mac下面无法调试的问题
## 配置文件说明
### .c_cpp_properties.json
这个文件主要是为了告诉vscode编辑器一些编译环境信息，包括编译路径方便编辑器进行代码检测和运行。
```json
{
  "configurations": [
    {
      "name": "macOS",
      "includePath": ["${workspaceFolder}/**"],
      "defines": [],
      "macFrameworkPath": ["/System/Library/Frameworks", "/Library/Frameworks"],
      "compilerPath": "/usr/bin/clang",
      "cStandard": "c11",
      "cppStandard": "c++17",
      "intelliSenseMode": "${default}"
    }
  ],
  "version": 4
}
```
### launch.json
这个文件是是在运行调试时的配置文件，告诉vscode运行说明调试器，指定执行的文件和需要输入的参数
```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "name": "(lldb) Launch",
      "type": "lldb",
      "request": "launch",
      "program": "${workspaceFolder}/helloworld.out",
      "args": [],
    }
  ]
}
```
### tasks.json
这个文件是一个编译的构建的说明
```json
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Build with Clang",
      "type": "shell",
      "command": "clang++",
      "args": [
        "-std=c++17",
        "-stdlib=libc++",
        "helloworld.cpp",
        "-o",
        "helloworld.out",
        "-g"
      ],
      "group": {
        "kind": "build",
        "isDefault": true
      }
    }
  ]
}
```
## 常用快捷命令
- shift + command + p 命令面板
- shift + command + b 编译
- F5 运行