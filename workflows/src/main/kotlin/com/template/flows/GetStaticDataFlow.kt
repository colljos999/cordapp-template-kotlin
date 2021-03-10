package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import com.template.service.StaticDataService
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC

@StartableByRPC
@InitiatingFlow
class GetStaticDataFlow : FlowLogic<String>() {
    @Suspendable
    override fun call() = serviceHub.cordaService(StaticDataService::class.java).getStaticData()
}