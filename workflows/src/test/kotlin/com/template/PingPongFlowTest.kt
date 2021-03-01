package com.template

import com.template.flows.Ping
import net.corda.core.concurrent.CordaFuture
import net.corda.core.identity.Party
import net.corda.core.utilities.getOrThrow
import net.corda.testing.node.MockNetwork
import net.corda.testing.node.MockNetworkParameters
import net.corda.testing.node.StartedMockNode
import net.corda.testing.node.TestCordapp
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class PingPongFlowTest {

    lateinit var network: MockNetwork
    lateinit var nodeA: StartedMockNode
    lateinit var nodeB: StartedMockNode

    @Before
    fun setup() {
        network = MockNetwork(
            MockNetworkParameters(
                cordappsForAllNodes = listOf(
                    TestCordapp.findCordapp("com.template.contracts"),
                    TestCordapp.findCordapp("com.template.flows")
                )
            )
        )
        nodeA = network.createPartyNode()
        nodeB = network.createPartyNode()
    }

    @After
    fun tearDown() {
        network.stopNodes()
    }

    @Test
    fun `ping pong`() {
        val pingPongFlow = Ping(nodeB.identity())
        nodeA.startFlow(pingPongFlow).runAndGet(network)
    }

    @Test
    fun `ping pong with node stop and re-start`() {
        val pingPongFlow = Ping(nodeB.identity())
        nodeA.startFlow(pingPongFlow).runAndGet(network)

         // I want to ensure my flow continues working after stopping and re-starting one of the nodes in the network.
        nodeB.stop()
        network.startNodes()    // re-start NodeB

        // Upon re-start you will see the following in the node log:
        // [WARN] 19:19:56,837 [Test worker] internal.NodeFlowManager. - Multiple flows are registered for InitiatingFlow: class com.template.flows.Ping, currently using: class com.template.flows.Pong
        // and a fatal error:
        // Unable to determine which flow to use when responding to: net.corda.core.flows.FinalityFlow. [net.corda.node.services.FinalityHandler, net.corda.node.services.FinalityHandler] are all registered with equal weight.
        // java.lang.IllegalStateException: Unable to determine which flow to use when responding to: net.corda.core.flows.FinalityFlow. [net.corda.node.services.FinalityHandler, net.corda.node.services.FinalityHandler] are all registered with equal weight.

        val anotherPingPongFlow = Ping(nodeB.identity())
        nodeA.startFlow(anotherPingPongFlow).runAndGet(network)
    }

    private fun <V> CordaFuture<V>.runAndGet(network: MockNetwork): V {
        network.runNetwork()
        return this.getOrThrow()
    }

    private fun StartedMockNode.identity(): Party {
        return this.info.legalIdentities.single()
    }
}