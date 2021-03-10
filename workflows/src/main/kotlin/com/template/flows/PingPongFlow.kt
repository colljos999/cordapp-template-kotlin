package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.*
import net.corda.core.identity.Party
import net.corda.core.utilities.ProgressTracker
import net.corda.core.utilities.unwrap

@InitiatingFlow
@StartableByRPC
class Ping(private val counterparty: Party) : FlowLogic<String>() {
    override val progressTracker = ProgressTracker()

    @Suspendable
    override fun call(): String {
        logger.info("Ping call ...")
        val counterpartySession = initiateFlow(counterparty)
        logger.info("Ping initiated session with ${counterparty.name}")
        logger.info("Ping sendAndReceive ...")
        val counterpartyData = counterpartySession.sendAndReceive<String>("ping")
        logger.info("Ping received response from sendAndReceive() ...")
        val msg = counterpartyData.unwrap { it }
        assert(msg == "pong")
        return msg
    }
}

@InitiatedBy(Ping::class)
class Pong(private val counterpartySession: FlowSession) : FlowLogic<Unit>() {
    @Suspendable
    override fun call() {
        logger.info("Pong call ...")
        val counterpartyData = counterpartySession.receive<String>()
        logger.info("Pong received response from ${counterpartySession.counterparty.name}: ${counterpartyData.unwrap{it}}")
        counterpartyData.unwrap { msg ->
            assert(msg == "ping")
        }
        logger.info("Pong sending response to ${counterpartySession.counterparty.name}")
        counterpartySession.send("pong")
    }
}