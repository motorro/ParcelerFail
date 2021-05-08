# ParcelerFail
Test project to illustrate Parceler problem

Compilation fails for Kotlin 1.5.0 and new backend for parcelable using nested generics:

```kotlin
@Parcelize
@TypeParceler<Pair<Int, Int>, IntToIntParceler>
data class FailingClass(val pair: Pair<Int, Int>): Parcelable
```

- run with `./gradlew test --rerun-tasks -PuseOldBackend=true` to use old backend (works)
- run with `./gradlew test --rerun-tasks -PuseOldBackend=false` to use new backend (fails)

```
> Task :app:compileDebugKotlin FAILED
e: java.lang.NullPointerException
	at org.jetbrains.kotlin.parcelize.ir.IrUtilsKt.parcelerWrite(irUtils.kt:48)
	at org.jetbrains.kotlin.parcelize.ir.IrCustomParcelSerializer.writeParcel(IrParcelSerializers.kt:223)
	at org.jetbrains.kotlin.parcelize.ir.IrParcelSerializersKt.writeParcelWith(IrParcelSerializers.kt:36)
	at org.jetbrains.kotlin.parcelize.ir.ParcelizeIrTransformer$visitClass$writeToParcel$1$1.invoke(ParcelizeIrTransformer.kt:161)
	at org.jetbrains.kotlin.parcelize.ir.ParcelizeIrTransformer$visitClass$writeToParcel$1$1.invoke(ParcelizeIrTransformer.kt:152)
	at org.jetbrains.kotlin.parcelize.ir.ParcelizeIrTransformer.transform(ParcelizeIrTransformer.kt:59)
	at org.jetbrains.kotlin.parcelize.ParcelizeIrGeneratorExtension.generate(ParcelizeIrGeneratorExtension.kt:19)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory$convertToIr$1.invoke(JvmIrCodegenFactory.kt:120)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory$convertToIr$1.invoke(JvmIrCodegenFactory.kt:116)
	at org.jetbrains.kotlin.psi2ir.Psi2IrTranslator.generateModuleFragment(Psi2IrTranslator.kt:91)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.convertToIr(JvmIrCodegenFactory.kt:140)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.convertToIr$default(JvmIrCodegenFactory.kt:66)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.generateModule(JvmIrCodegenFactory.kt:61)
	at org.jetbrains.kotlin.codegen.KotlinCodegenFacade.compileCorrectFiles(KotlinCodegenFacade.java:35)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.generate(KotlinToJVMBytecodeCompiler.kt:592)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:212)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:155)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:169)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:52)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:88)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:44)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:98)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:386)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:110)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileIncrementally(IncrementalCompilerRunner.kt:303)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl$rebuild(IncrementalCompilerRunner.kt:99)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:124)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:74)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:607)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:96)
	at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1659)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:834)
```
