package com.template

import com.template.flows.GetStaticDataFlow
import net.corda.client.rpc.CordaRPCClient
import net.corda.core.identity.CordaX500Name
import net.corda.core.messaging.startFlow
import net.corda.core.utilities.getOrThrow
import net.corda.node.services.Permissions
import net.corda.testing.driver.DriverParameters
import net.corda.testing.driver.driver
import net.corda.testing.node.NotarySpec
import net.corda.testing.node.TestCordapp
import net.corda.testing.node.User
import org.junit.Test
import kotlin.test.assertEquals

class DriverShutdownFailureTest {
    private val notaryConfig = "coadjute_notary" to "O=Notary,L=London,C=GB"

    private val contractsCordapp = TestCordapp.findCordapp("com.template.contracts")
    private val workflowsCordapp = TestCordapp.findCordapp("com.template.flows").withConfig(mapOf(notaryConfig))
    private val user = User("jose", "blogos", setOf(Permissions.all()))

    private val driverParams = DriverParameters(startNodesInProcess = true,
        cordappsForAllNodes = listOf(contractsCordapp, workflowsCordapp),
        notarySpecs = listOf(NotarySpec(CordaX500Name("Notary", "London", "GB"))))

    @Test
    fun `start simple flow does not shutdown properly`() =  driver(driverParams) {
        val nodeHandle = startNode(rpcUsers = listOf(user)).getOrThrow()
        CordaRPCClient(nodeHandle.rpcAddress).start(user.username, user.password).use {
            val data = it.proxy.startFlow(::GetStaticDataFlow).returnValue.getOrThrow()
            assertEquals("static data", data)
        }
        nodeHandle.stop()
    }
}