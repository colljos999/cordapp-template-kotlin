Spring Boot in Corda node

Objective
To startup a Corda node inclusive of the client Controller RESTful endpoints running within a Spring Boot server.
See “com.template.webserverSprintBootService” to understand how the bootstrapping of Spring is achieved as a Corda Service.

Deployment and Packaging

Option 1
- build single Corda client.jar file inclusive of contracts & flows, and spring server & bootstrapper
- Deploy client.jar to the node cordapps directory and re-start the node.

Option 2
- build a Spring Boot jar (client-boot.jar), and copy to the node cordapps directory
- Build contract and workflows jar (as normal) and copy to the node cordapps directory

Notes:
- We package a sample test flow to validate node-node comms:
>>flow start Ping counterparty: "O=PartyB, L=New York, C=US"
- We include a cordapp declaration in our client jar as follows (which you will see correctly processed by the node logs upon startup):

cordapp {
targetPlatformVersion corda_platform_version
minimumPlatformVersion corda_platform_version
contract {
name "Corda Web Service"
vendor "Corda Open Source"
licence "Apache License, Version 2.0"
versionId 1
}
signing {
enabled false
}
sealing {
enabled false
}
}

NODE START-UP EXECUTION OUTCOME:

Option 1 = Using the vanilla JAR file:

cd <top-level-project>
./gradlew jar
cp clients/build/libs/clients-0.1.jar build/nodes/PartyA/cordapps/
cp build/nodes/PartyA
java -Xmx2G -jar corda.jar

[ERROR] 2021-03-10T13:28:47,368Z [NodeLifecycleEventsDistributor-0] boot.SpringApplication. - Application run failed
java.lang.IllegalArgumentException: No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.
at org.springframework.util.Assert.notEmpty(Assert.java:450) ~[?:?]
at org.springframework.boot.autoconfigure.AutoConfigurationImportSelector.getCandidateConfigurations(AutoConfigurationImportSelector.java:160) ~[?:?]
at org.springframework.boot.autoconfigure.AutoConfigurationImportSelector.selectImports(AutoConfigurationImportSelector.java:96) ~[?:?]
at org.springframework.boot.autoconfigure.AutoConfigurationImportSelector$AutoConfigurationGroup.process(AutoConfigurationImportSelector.java:386) ~[?:?]
at org.springframework.context.annotation.ConfigurationClassParser$DeferredImportSelectorGrouping.getImports(ConfigurationClassParser.java:830) ~[?:?]
at org.springframework.context.annotation.ConfigurationClassParser.processDeferredImportSelectors(ConfigurationClassParser.java:563) ~[?:?]
at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:188) ~[?:?]
at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:316) ~[?:?]
at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:233) ~[?:?]
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:273) ~[?:?]
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:93) ~[?:?]
at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694) ~[?:?]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532) ~[?:?]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:140) ~[?:?]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:759) ~[?:?]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:395) ~[?:?]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:327) ~[?:?]

Option 2 = Using the boot JAR file:

cd <top-level-project>
cd clients
./gradlew bootJar
cd ..
cp clients/build/libs/clients-0.1-boot.jar build/nodes/PartyA/cordapps/
cp contracts/build/libs/contracts-0.1.jar build/nodes/PartyA/cordapps/
cp workflows/build/libs/workflows-0.1.jar build/nodes/PartyA/cordapps/
java -Xmx2G -jar corda.jar

[INFO ] 2021-03-10T13:54:52,875Z [main] cordapp.JarScanningCordappLoader. - Scanning CorDapp in file:/Users/colljos/repos/corda/fork-cordapp-template-kotlin/build/nodes/PartyA/cordapps/contracts-0.1.jar
[INFO ] 2021-03-10T13:54:52,987Z [main] cordapp.JarScanningCordappLoader. - Scanning CorDapp in file:/Users/colljos/repos/corda/fork-cordapp-template-kotlin/build/nodes/PartyA/cordapps/workflows-0.1.jar
[INFO ] 2021-03-10T13:54:53,009Z [main] cordapp.JarScanningCordappLoader. - Scanning CorDapp in file:/Users/colljos/repos/corda/fork-cordapp-template-kotlin/build/nodes/PartyA/cordapps/clients-0.1-boot.jar
[WARN ] 2021-03-10T13:54:56,099Z [main] cordapp.JarScanningCordappLoader. - Unable to load class com.template.webserver.SprintBootService
java.lang.ClassNotFoundException: com.template.webserver.SprintBootService
at java.net.URLClassLoader.findClass(URLClassLoader.java:382) ~[?:1.8.0_282]
at java.lang.ClassLoader.loadClass(ClassLoader.java:419) ~[?:1.8.0_282]
at java.lang.ClassLoader.loadClass(ClassLoader.java:352) ~[?:1.8.0_282]
at java.lang.Class.forName0(Native Method) ~[?:1.8.0_282]
at java.lang.Class.forName(Class.java:348) ~[?:1.8.0_282]
at net.corda.node.internal.cordapp.JarScanningCordappLoader.loadClass(JarScanningCordappLoader.kt:361) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader.access$loadClass(JarScanningCordappLoader.kt:49) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader$RestrictedScanResult.getClassesWithAnnotation(JarScanningCordappLoader.kt:422) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader.findServices(JarScanningCordappLoader.kt:281) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader.toCordapp(JarScanningCordappLoader.kt:186) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader.loadCordapps(JarScanningCordappLoader.kt:113) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader.access$loadCordapps(JarScanningCordappLoader.kt:49) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader$cordapps$2.invoke(JarScanningCordappLoader.kt:61) ~[corda-node-4.7.jar:?]
at net.corda.node.internal.cordapp.JarScanningCordappLoader$cordapps$2.invoke(JarScanningCordappLoader.kt:49) ~[corda-node-4.7.jar:?]