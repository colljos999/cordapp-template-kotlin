package com.template.webserver

import com.template.flows.Ping
import net.corda.core.messaging.startFlow
import net.corda.core.utilities.getOrThrow
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Define your API endpoints here.
 */
@RestController
@RequestMapping("/") // The paths for HTTP requests are relative to this base path.
class Controller(rpc: NodeRPCConnection) {

    companion object {
        private val logger = LoggerFactory.getLogger(RestController::class.java)
    }

    private val proxy = rpc.proxy

    @GetMapping(value = ["/nodeinfo"], produces = ["text/plain"])
    private fun nodeInfo(): String {
        val nodeInfo = proxy.nodeInfo().toString()
        logger.info("NodeInfo: $nodeInfo")
        return nodeInfo
    }

    @GetMapping(value = ["/ping"])
    private fun ping(): String {
        val nodeInfos = proxy.networkMapSnapshot()
        val responses = nodeInfos.map {
            it.legalIdentities.map { party ->
                proxy.startFlow(::Ping, party).returnValue.getOrThrow()
            }
        }.flatten()
        return responses.joinToString()
    }
}