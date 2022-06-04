# ASMStudy
1. [bilibili 字节码插桩技术实现自动化方法耗时记录](https://www.bilibili.com/video/BV1Tv4y1f7h4?p=1)和[字节码增强技术探索](https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html)配合食用

   ASM使用

   1. 引入ASM依赖

      ```groovy
      testImplementation 'org.ow2.asm:asm:9.1'
      testImplementation 'org.ow2.asm:asm-commons:9.1'
      ```

   2. 准备待插桩Class

   3. 借助ASM Bytecode Outline编码实现

   4. Android实现

      1. 如何获得所有的class
      2. Android打包流程：Gradle Transform
      3. 其他场景

2. [一起玩转 Android 项目中的字节码](https://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650244795&idx=1&sn=cdfc4acec8b0d2b5c82fd9d884f32f09&chksm=886377d4bf14fec2fc822cd2b3b6069c36cb49ea2814d9e0e2f4a6713f4e86dfc0b1bebf4d39&mpshare=1&scene=1&srcid=1217NjDpKNvdgalsqBQLJXjX%23rd) -> OkHttp-Plugin

3. 慕课网Android 应用程序构建实战原理精讲：第六章字节码插桩实现路由组件自动注册

4. 基于 ASM 的字节码处理工具：[Hunter](https://github.com/Leaking/Hunter)使用方式和源码分析

5. 极客时间之Android开发高手课《编译插桩的三种方法：AspectJ、ASM、ReDex》

6. 极客时间之Android开发高手课《练习Sample跑起来 | ASM插桩强化练习》

8. [深入探索编译插桩技术（四、ASM）](https://juejin.im/post/5e8d87c4f265da47ad218e6b)

#### 概念：

1. ClassReader：用于读取已经编译好的.class文件。
2. ClassWriter：用于重新构建编译后的类，如修改类名、属性以及方法，也可以生成新的类的字节码文件。
3. 各种Visitor类：如上所述，CoreAPI根据字节码从上到下依次处理，对于字节码文件中不同的区域有不同的Visitor，比如用于访问方法的MethodVisitor、用于访问类变量的FieldVisitor、用于访问注解的AnnotationVisitor等。为了实现AOP，重点要使用的是MethodVisitor。

#### 开源框架：

1. 基于 ASM 的字节码处理工具：[Hunter](https://github.com/Leaking/Hunter)
1. [ByteX](https://github.com/bytedance/ByteX) 是一个基于gradle transform api和ASM的字节码插件平台

#### docker搭建maven

```shell
# use klo2k/nexus3 version of Nexus on ARM
docker pull klo2k/nexus3
docker run -d -p 8081:8081 --name nexus klo2k/nexus3
docker ps
docker exec -it 920 /bin/bash
cd /nexus-data/
cat admin.password
# 2506c122-1412-4863-ac9e-4daa41812d63
curl http://localhost:8081/
# 配置阿里云公共仓库，参考：https://blog.csdn.net/ThinkWon/article/details/94346681
# 地址：http://192.168.1.3:8081/repository/maven-snapshots/
```

#### 发布gradle插件到maven

```shell
# 上传脚本
apply plugin: 'maven-publish'
afterEvaluate {
    publishing {
        publications {
            maven(MavenPublication) {
                groupId = "com.imooc.router"
                artifactId = 'router-gradle-plugin'
                version = '0.0.1-SNAPSHOT'
                description 'library for android'
            }
        }
        repositories {
            maven {
                allowInsecureProtocol = true
                url = 'http://192.168.1.3:8081/repository/maven-snapshots/'
                credentials {
                    username = 'admin'
                    password = 'qwer1234'
                }
            }
        }
    }
}
```

#### 参考：

1. **[Awesome-Android-Architecture](https://github.com/JsonChao/Awesome-Android-Architecture)**
