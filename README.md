# ASMStudy
1. [bilibili 字节码插桩技术实现自动化方法耗时记录](https://www.bilibili.com/video/BV1Tv4y1f7h4?p=1)

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

2. [ASM 官网](https://asm.ow2.io/)
