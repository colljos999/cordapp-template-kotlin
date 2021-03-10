When running DriverShutdownFailureTest, the node driver takes over 30 seconds to shutdown, and throws several WARNINGS
and an ERROR message:

RUN #1

[INFO] 15:43:05,936 [Thread-0 (ActiveMQ-client-factory-threads-605072509)] rpc.RPCServer. - Detected RPC client disconnect on address rpc.client.jose.6971739561970307379, scheduling for reaping {actor_id=jose, actor_owning_identity=O=Bob Plc-10452, L=London, C=GB, actor_store_id=NODE_CONFIG, invocation_id=b3fad084-af62-413e-98a5-e07819cda645, invocation_timestamp=2021-03-10T15:43:05.710Z, origin=jose, session_id=b7e2c546-620f-465f-8be4-32aa7a05e2bf, session_timestamp=2021-03-10T15:43:05.681Z}
Shutting down ...
[INFO] 15:43:05,945 [Test worker] messaging.P2PMessagingClient. - Status change to false
[INFO] 15:43:05,945 [Test worker] internal.Node. - MessagingService active change to: false
[INFO] 15:43:05,952 [Bob Plc-10452] internal.DriverDSLImpl. - Node run completed
[WARN] 15:43:08,069 [Thread-0 (ActiveMQ-client-factory-threads-1802642493)] core.client. - AMQ212037: Connection failure has been detected: AMQ119015: The connection was disconnected because of server shutdown [code=DISCONNECTED]
[WARN] 15:43:08,073 [Thread-0 (ActiveMQ-client-factory-threads-1802642493)] internal.RPCClientProxyHandler. - Terminating observables.
[INFO] 15:43:08,088 [Test worker] persistence.CordaPersistence. - Closing HikariDataSource (HikariPool-2)
[INFO] 15:43:08,088 [Test worker] hikari.HikariDataSource. - HikariPool-2 - Shutdown initiated...
[INFO] 15:43:08,095 [Test worker] hikari.HikariDataSource. - HikariPool-2 - Shutdown completed.
[INFO] 15:43:08,098 [Test worker] internal.Node. - Shutdown complete
[INFO] 15:43:08,098 [Test worker] network.NodeInfoFilesCopier. - Stopped watching: /Users/colljos/repos/corda/fork-cordapp-template-kotlin/workflows/build/node-driver/20210310-154245.684-BAB94C42FFB0B905/BobPlc-10452
[WARN] 15:43:08,099 [Thread-0 (ActiveMQ-client-factory-threads-1802642493)] core.client. - AMQ212004: Failed to connect to server.
[ERROR] 15:43:08,099 [Thread-0 (ActiveMQ-client-factory-threads-1802642493)] internal.RPCClientProxyHandler. - Could not reconnect to the RPC server.
Shutting down ...
[WARN] 15:43:38,107 [Test worker] lifecycle.NodeLifecycleEventsDistributor. - Not distributing net.corda.nodeapi.internal.lifecycle.NodeLifecycleEvent$StateMachineStopped@1ca1715a as executor been already shutdown. Double close() case?
[WARN] 15:43:38,107 [Test worker] lifecycle.NodeLifecycleEventsDistributor. - Not distributing net.corda.nodeapi.internal.lifecycle.NodeLifecycleEvent$BeforeNodeStop@5d2320d1 as executor been already shutdown. Double close() case?
[WARN] 15:43:38,107 [Test worker] lifecycle.NodeLifecycleEventsDistributor. - Not distributing net.corda.nodeapi.internal.lifecycle.NodeLifecycleEvent$AfterNodeStop@c33442 as executor been already shutdown. Double close() case?
[INFO] 15:43:38,107 [Test worker] internal.Node. - Shutdown complete
[INFO] 15:43:38,118 [Thread-0 (ActiveMQ-client-factory-threads-1942476770)] rpc.RPCServer. - Detected RPC client disconnect on address rpc.client.default.2228211674361370844, scheduling for reaping {actor_id=default, actor_owning_identity=O=Notary, L=London, C=GB, actor_store_id=NODE_CONFIG, invocation_id=c01ba570-bf74-4296-9877-4d5c1868a6ef, invocation_timestamp=2021-03-10T15:43:04.138Z, origin=default, session_id=b9adb4c7-71ae-46f5-844a-4ae5ad71f25d, session_timestamp=2021-03-10T15:43:03.944Z}
Shutting down ...
[INFO] 15:43:38,120 [Test worker] messaging.P2PMessagingClient. - Status change to false
[INFO] 15:43:38,120 [Test worker] internal.Node. - MessagingService active change to: false
[INFO] 15:43:38,122 [Notary] internal.DriverDSLImpl. - Node run completed
[INFO] 15:43:40,222 [Test worker] persistence.CordaPersistence. - Closing HikariDataSource (HikariPool-1)
[INFO] 15:43:40,222 [Test worker] hikari.HikariDataSource. - HikariPool-1 - Shutdown initiated...
[INFO] 15:43:40,225 [Test worker] hikari.HikariDataSource. - HikariPool-1 - Shutdown completed.
[INFO] 15:43:40,226 [Test worker] internal.Node. - Shutdown complete

RUN #2

[INFO] 15:47:00,107 [Thread-0 (ActiveMQ-client-factory-threads-1305596309)] rpc.RPCServer. - Detected RPC client disconnect on address rpc.client.jose.793070968940114858, scheduling for reaping {actor_id=jose, actor_owning_identity=O=Bank A-10460, L=London, C=GB, actor_store_id=NODE_CONFIG, invocation_id=1a3b2125-f465-45a7-bb33-324db849a9ca, invocation_timestamp=2021-03-10T15:46:59.879Z, origin=jose, session_id=1f10007c-2523-4a69-9660-bbd31702ddfb, session_timestamp=2021-03-10T15:46:59.852Z}
Shutting down ...
[INFO] 15:47:00,116 [Test worker] messaging.P2PMessagingClient. - Status change to false
[INFO] 15:47:00,116 [Test worker] internal.Node. - MessagingService active change to: false
[INFO] 15:47:00,123 [Bank A-10460] internal.DriverDSLImpl. - Node run completed
[WARN] 15:47:02,249 [Thread-0 (ActiveMQ-client-factory-threads-1729183259)] core.client. - AMQ212037: Connection failure has been detected: AMQ119015: The connection was disconnected because of server shutdown [code=DISCONNECTED]
[WARN] 15:47:02,252 [Thread-0 (ActiveMQ-client-factory-threads-1729183259)] internal.RPCClientProxyHandler. - Terminating observables.
[INFO] 15:47:02,267 [Test worker] persistence.CordaPersistence. - Closing HikariDataSource (HikariPool-2)
[INFO] 15:47:02,267 [Test worker] hikari.HikariDataSource. - HikariPool-2 - Shutdown initiated...
[INFO] 15:47:02,275 [Test worker] hikari.HikariDataSource. - HikariPool-2 - Shutdown completed.
[INFO] 15:47:02,278 [Test worker] internal.Node. - Shutdown complete
[INFO] 15:47:02,278 [Test worker] network.NodeInfoFilesCopier. - Stopped watching: /Users/colljos/repos/corda/fork-cordapp-template-kotlin/workflows/build/node-driver/20210310-154637.914-DF7578BB1D0558FA/BankA-10460
[WARN] 15:47:02,280 [Thread-0 (ActiveMQ-client-factory-threads-1729183259)] core.client. - AMQ212004: Failed to connect to server.
[ERROR] 15:47:02,280 [Thread-0 (ActiveMQ-client-factory-threads-1729183259)] internal.RPCClientProxyHandler. - Could not reconnect to the RPC server.
Shutting down ...
[WARN] 15:47:02,361 [Test worker] lifecycle.NodeLifecycleEventsDistributor. - Not distributing net.corda.nodeapi.internal.lifecycle.NodeLifecycleEvent$StateMachineStopped@409bccf3 as executor been already shutdown. Double close() case?
[WARN] 15:47:02,361 [Test worker] lifecycle.NodeLifecycleEventsDistributor. - Not distributing net.corda.nodeapi.internal.lifecycle.NodeLifecycleEvent$BeforeNodeStop@367c6773 as executor been already shutdown. Double close() case?
[WARN] 15:47:02,361 [Test worker] lifecycle.NodeLifecycleEventsDistributor. - Not distributing net.corda.nodeapi.internal.lifecycle.NodeLifecycleEvent$AfterNodeStop@6a5720f0 as executor been already shutdown. Double close() case?
[INFO] 15:47:02,361 [Test worker] internal.Node. - Shutdown complete
[INFO] 15:47:02,372 [Thread-0 (ActiveMQ-client-factory-threads-1056339982)] rpc.RPCServer. - Detected RPC client disconnect on address rpc.client.default.589184600781907453, scheduling for reaping {actor_id=default, actor_owning_identity=O=Notary, L=London, C=GB, actor_store_id=NODE_CONFIG, invocation_id=af24a251-f263-4ca9-83a2-0e49e1aa4fc4, invocation_timestamp=2021-03-10T15:46:57.750Z, origin=default, session_id=124287d3-2806-4514-8737-86ae4a3ff42a, session_timestamp=2021-03-10T15:46:57.521Z}
Shutting down ...
[INFO] 15:47:02,373 [Test worker] messaging.P2PMessagingClient. - Status change to false
[INFO] 15:47:02,373 [Test worker] internal.Node. - MessagingService active change to: false
[INFO] 15:47:02,375 [Notary] internal.DriverDSLImpl. - Node run completed
[ERROR] 15:47:02,389 [KQueueEventLoopGroup-6-1] core.client. - AMQ214015: Failed to execute connection life cycle listener
 java.util.concurrent.RejectedExecutionException: Task org.apache.activemq.artemis.utils.actors.ProcessorBase$$Lambda$99/1603875410@bf9fbe7 rejected from java.util.concurrent.ThreadPoolExecutor@202081f4[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 10]
	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063) ~[?:1.8.0_282]
	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830) ~[?:1.8.0_282]
	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379) ~[?:1.8.0_282]
	at org.apache.activemq.artemis.utils.actors.ProcessorBase.onAddedTaskIfNotRunning(ProcessorBase.java:205) ~[artemis-commons-2.6.2.jar:2.6.2]
	at org.apache.activemq.artemis.utils.actors.ProcessorBase.task(ProcessorBase.java:193) ~[artemis-commons-2.6.2.jar:2.6.2]
	at org.apache.activemq.artemis.utils.actors.OrderedExecutor.execute(OrderedExecutor.java:54) ~[artemis-commons-2.6.2.jar:2.6.2]
	at org.apache.activemq.artemis.core.remoting.impl.netty.ActiveMQChannelHandler.exceptionCaught(ActiveMQChannelHandler.java:106) ~[artemis-core-client-2.6.2.jar:2.6.2]
	at io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:300) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.notifyHandlerException(AbstractChannelHandlerContext.java:825) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:262) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:239) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInputClosed(ByteToMessageDecoder.java:386) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInactive(ByteToMessageDecoder.java:351) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:260) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:239) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInputClosed(ByteToMessageDecoder.java:386) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInactive(ByteToMessageDecoder.java:351) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.ssl.SslHandler.channelInactive(SslHandler.java:1084) ~[netty-handler-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:260) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:239) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelInactive(DefaultChannelPipeline.java:1405) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:260) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.DefaultChannelPipeline.fireChannelInactive(DefaultChannelPipeline.java:901) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannel$AbstractUnsafe$8.run(AbstractChannel.java:818) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:164) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:472) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.kqueue.KQueueEventLoop.run(KQueueEventLoop.java:273) ~[netty-transport-native-kqueue-4.1.24.Final-osx-x86_64.jar:4.1.24.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:989) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at java.lang.Thread.run(Thread.java:748) [?:1.8.0_282]
[ERROR] 15:47:04,452 [KQueueEventLoopGroup-3-1] core.client. - AMQ214015: Failed to execute connection life cycle listener
 java.util.concurrent.RejectedExecutionException: Task org.apache.activemq.artemis.utils.actors.ProcessorBase$$Lambda$99/1603875410@75419e24 rejected from java.util.concurrent.ThreadPoolExecutor@5c1e3ef1[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 2]
	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063) ~[?:1.8.0_282]
	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830) ~[?:1.8.0_282]
	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379) ~[?:1.8.0_282]
	at org.apache.activemq.artemis.utils.actors.ProcessorBase.onAddedTaskIfNotRunning(ProcessorBase.java:205) ~[artemis-commons-2.6.2.jar:2.6.2]
	at org.apache.activemq.artemis.utils.actors.ProcessorBase.task(ProcessorBase.java:193) ~[artemis-commons-2.6.2.jar:2.6.2]
	at org.apache.activemq.artemis.utils.actors.OrderedExecutor.execute(OrderedExecutor.java:54) ~[artemis-commons-2.6.2.jar:2.6.2]
	at org.apache.activemq.artemis.core.remoting.impl.netty.ActiveMQChannelHandler.exceptionCaught(ActiveMQChannelHandler.java:106) ~[artemis-core-client-2.6.2.jar:2.6.2]
	at io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:300) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.notifyHandlerException(AbstractChannelHandlerContext.java:825) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:262) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:239) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInputClosed(ByteToMessageDecoder.java:386) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInactive(ByteToMessageDecoder.java:351) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:260) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:239) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInputClosed(ByteToMessageDecoder.java:386) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelInactive(ByteToMessageDecoder.java:351) ~[netty-codec-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.handler.ssl.SslHandler.channelInactive(SslHandler.java:1084) ~[netty-handler-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:260) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:239) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelInactive(DefaultChannelPipeline.java:1405) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:260) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:246) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.DefaultChannelPipeline.fireChannelInactive(DefaultChannelPipeline.java:901) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.AbstractChannel$AbstractUnsafe$8.run(AbstractChannel.java:818) ~[netty-transport-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:164) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:472) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.channel.kqueue.KQueueEventLoop.run(KQueueEventLoop.java:273) ~[netty-transport-native-kqueue-4.1.24.Final-osx-x86_64.jar:4.1.24.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:989) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30) ~[netty-common-4.1.46.Final.jar:4.1.46.Final]
	at java.lang.Thread.run(Thread.java:748) [?:1.8.0_282]
[INFO] 15:47:04,464 [Test worker] persistence.CordaPersistence. - Closing HikariDataSource (HikariPool-1)
[INFO] 15:47:04,464 [Test worker] hikari.HikariDataSource. - HikariPool-1 - Shutdown initiated...
[INFO] 15:47:04,467 [Test worker] hikari.HikariDataSource. - HikariPool-1 - Shutdown completed.
[INFO] 15:47:04,468 [Test worker] internal.Node. - Shutdown complete