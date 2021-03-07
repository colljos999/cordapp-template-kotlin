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

    private fun <V> CordaFuture<V>.runAndGet(network: MockNetwork): V {
        network.runNetwork()
        return this.getOrThrow()
    }

    private fun StartedMockNode.identity(): Party {
        return this.info.legalIdentities.single()
    }
}