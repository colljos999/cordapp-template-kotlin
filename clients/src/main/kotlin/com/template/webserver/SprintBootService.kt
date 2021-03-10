package com.template.webserver

import net.corda.core.node.AppServiceHub
import net.corda.core.node.services.CordaService
import net.corda.core.node.services.ServiceLifecycleEvent
import net.corda.core.node.services.ServiceLifecycleObserver
import net.corda.core.serialization.SingletonSerializeAsToken
import net.corda.core.utilities.loggerFor
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Our Spring Boot application.
 */
@SpringBootApplication
private open class StarterWebServer

@CordaService
class SprintBootService (private val serviceHub: AppServiceHub) : SingletonSerializeAsToken() {

    init {
        loggerFor<SprintBootService>().info("SpringBootService init starting ...")

        // Optional: Express interest in receiving lifecycle events
        serviceHub.register(observer = object : ServiceLifecycleObserver {
            override fun onServiceLifecycleEvent(event: ServiceLifecycleEvent) {
                //Lifecycle event handling code
                loggerFor<SprintBootService>().info("ServiceLifecycleObserver received event: ${event.name} ...")
                if (event == ServiceLifecycleEvent.STATE_MACHINE_STARTED) {
                    startup()
                }
            }
        })
    }

//    @PostConstruct
    fun startup() {
        loggerFor<SprintBootService>().info("SpringBootService PostConstruct startup ...")
        val app = SpringApplication(StarterWebServer::class.java)
        app.setBannerMode(Banner.Mode.OFF)
        app.webApplicationType = WebApplicationType.SERVLET
        app.setDefaultProperties(mapOf("server.port" to "10100"))
        app.run()
        loggerFor<SprintBootService>().info("SpringBootService PostConstruct completed ...")
    }
}